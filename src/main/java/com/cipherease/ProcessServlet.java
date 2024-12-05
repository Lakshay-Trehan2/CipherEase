package com.cipherease;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@WebServlet("/process")
public class ProcessServlet extends HttpServlet {
    // WARNING: In a real application, use a secure key management system!
    private static final String AES_KEY = "MySecretKey12345"; 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the text, algorithm, and operation from the request parameters
        String text = request.getParameter("text");
        String algorithm = request.getParameter("algorithm");
        String operation = request.getParameter("operation");

        String result;
        if ("aes".equals(algorithm)) {
            // Process the text using AES encryption/decryption
            result = processAES(text, operation);
        } else {
            // Return an error message for unsupported algorithms
            result = "Unsupported algorithm for server-side processing";
        }

        // Set the response content type and character encoding
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(result);
    }

    private String processAES(String text, String operation) {
        try {
            // WARNING: In a real application, use a secure key management system!
            String key = "MySecretKey12345"; 
            // Initialization vector for CBC mode
            String iv = "1234567890123456"; 

            // Create a SecretKeySpec object from the key
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
            // Create an IvParameterSpec object from the initialization vector
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));
            // Create a Cipher object for AES/CBC/PKCS5Padding
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            if ("encrypt".equals(operation)) {
                // Initialize the cipher for encryption
                cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
                // Encrypt the text and encode it with Base64
                byte[] encryptedBytes = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
                return Base64.getEncoder().encodeToString(encryptedBytes);
            } else {
                // Initialize the cipher for decryption
                cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
                // Decode the text from Base64 and decrypt it
                byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(text));
                return new String(decryptedBytes, StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            // Print the stack trace and return an error message
            e.printStackTrace();
            return "Error processing AES: " + e.getMessage();
        }
    }
}