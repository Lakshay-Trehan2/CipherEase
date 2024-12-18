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

@WebServlet("/process")
public class ProcessServlet extends HttpServlet {
    private static final String AES_KEY = "MySecretKey12345"; // In a real application, use a secure key management system

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");
        String algorithm = request.getParameter("algorithm");
        String operation = request.getParameter("operation");

        String result;
        if ("aes".equals(algorithm)) {
            result = processAES(text, operation);
        } else {
            result = "Unsupported algorithm for server-side processing";
        }

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(result);
    }

    private String processAES(String text, String operation) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(AES_KEY.getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            if ("encrypt".equals(operation)) {
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                byte[] encryptedBytes = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
                return Base64.getEncoder().encodeToString(encryptedBytes);
            } else {
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(text));
                return new String(decryptedBytes, StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error processing AES: " + e.getMessage();
        }
    }
}

