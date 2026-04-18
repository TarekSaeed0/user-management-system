package org.ieee.sscs.team2.user;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class PasswordHashing {
    public static String hashPassword(String rawPassword){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(rawPassword.getBytes(StandardCharsets.UTF_8));
            StringBuilder result = new StringBuilder();
            for (byte b : hash) {
            result.append(String.format("%02x", b));
            }
            return result.toString();
        } catch (Exception e) {
        throw new RuntimeException(e);
        }
    }
}