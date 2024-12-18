package com.cipherease;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

// Annotation to define the URL pattern for the servlet
@WebServlet("/process")
public class ProcessServlet extends HttpServlet {
    // Key for AES encryption and decryption (should be securely managed in production)
    private static final String AES_KEY = "MySecretKey12345"; 

    // Handles POST requests sent to the servlet
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the 'text', 'algorithm', and 'operation' parameters from the HTTP request
        String text = request.getParameter("text");
        String algorithm = request.getParameter("algorithm");
        String operation = request.getParameter("operation");

        // Variable to store the result of processing
        String result;
        // Check if the algorithm is AES; process accordingly
        if ("aes".equals(algorithm)) {
            result = processAES(text, operation);
        } else {
            // Return a message if the algorithm is unsupported
            result = "Unsupported algorithm for server-side processing";
        }

        // Set response content type and encoding
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        // Write the result back to the client
        response.getWriter().write(result);
    }

    // Method to process AES encryption or decryption
    private String processAES(String text, String operation) {
        try {
            // Create a SecretKeySpec using the AES key
            SecretKeySpec secretKey = new SecretKeySpec(AES_KEY.getBytes(StandardCharsets.UTF_8), "AES");
            // Initialize the Cipher with AES algorithm and padding
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            // Check the operation type and perform the respective processing
            if ("encrypt".equals(operation)) {
                // Initialize cipher for encryption and encrypt the input text
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                byte[] encryptedBytes = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
                // Encode the encrypted bytes to Base64 and return
                return Base64.getEncoder().encodeToString(encryptedBytes);
            } else {
                // Initialize cipher for decryption and decrypt the input Base64 text
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(text));
                // Convert decrypted bytes to string and return
                return new String(decryptedBytes, StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            // Print the stack trace for debugging and return an error message
            e.printStackTrace();
            return "Error processing AES: " + e.getMessage();
        }
    }
}
