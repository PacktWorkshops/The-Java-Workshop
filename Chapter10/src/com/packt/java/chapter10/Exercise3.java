package com.packt.java.chapter10;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Exercise3 {

    public static void main(String[] args) {
        try {
            String algorithm = "AES";
            Key secretKey = KeyGenerator.getInstance(algorithm).generateKey();
            String transformation = algorithm + "/CBC/NoPadding";
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            Path pathToFile = Path.of("res/plaintext.txt");
            File plaintext = pathToFile.toFile();

            File ciphertext = Path.of("res/ciphertext.txt").toFile();
            if (ciphertext.exists()) {
                ciphertext.delete();
            }

            try (FileInputStream fileInputStream = new FileInputStream(plaintext);
                 FileOutputStream fileOutputStream = new FileOutputStream(ciphertext);
                 CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, cipher)) {
                fileOutputStream.write(cipher.getIV());
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fileInputStream.read(buffer)) > 0){
                    cipherOutputStream.write(buffer, 0, length);
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
