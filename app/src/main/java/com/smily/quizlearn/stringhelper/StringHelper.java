package com.smily.quizlearn.stringhelper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringHelper {
    public String hashPassword(String input){
        byte[] hashBytes = null;
        try {
            // Create a MessageDigest object for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Calculate the hash value for the input bytes
            hashBytes = digest.digest(input.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // Convert the hash bytes to a hexadecimal string representation
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
