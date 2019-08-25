package com.packt.java.chapter10;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class Exercise2 {

    public static void main(String[] args) {
        try {
            String plaintext = "My secret message";
            String algorithm = "RSA";
            KeyPair keyPair = KeyPairGenerator.getInstance(algorithm).generateKeyPair();
            String transformation = algorithm + "/ECB/PKCS1Padding";
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());

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
