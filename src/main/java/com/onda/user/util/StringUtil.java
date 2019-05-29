/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Xrio
 */
public class StringUtil {

    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty() || s.equals(" ");
    }
    
    public static String hash(String password) {

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] salt = new byte[16];
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error while encrypting password");
            return null;
        }
        
    }
}
