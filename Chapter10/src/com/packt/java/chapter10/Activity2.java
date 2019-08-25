package com.packt.java.chapter10;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Activity2 {

    public static void main(String[] args) {
        try {
            String algorithm = "AES";
            Key privateKey = KeyGenerator.getInstance(algorithm).generateKey();
            String transformation = algorithm + "/ECB/NoPadding";
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);

            String plaintext = "This is 16 bytes";
            byte[] ciphertext = new byte[cipher.getOutputSize(plaintext.getBytes().length)];
            int encryptedLength = cipher.update(plaintext.getBytes(), 0, plaintext.getBytes().length, ciphertext);
            cipher.doFinal(ciphertext, encryptedLength);

            System.out.println(new String(ciphertext));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (ShortBufferException e) {
            e.printStackTrace();
        }
    }
}
