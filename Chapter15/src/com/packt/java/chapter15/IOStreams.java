package com.packt.java.chapter15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class IOStreams {

    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir") + File.separator +  "res/authors.csv";

        try (Stream<String> authors = Files.lines(Paths.get(filePath))) {
            authors.onClose(() -> {
                System.out.println("Closed");
            }).forEach((author) -> {
                System.out.println(author);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (Stream<String> authors = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath))).lines()
        ) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
