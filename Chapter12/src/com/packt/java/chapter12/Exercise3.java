package com.packt.java.chapter12;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise3 {

    public static void main(String[] args) {

        String filePath = System.getProperty("user.dir") + File.separator +  "res" + File.separator + "packt.txt";
        try {
            String packtDump = new String(Files.readAllBytes(Paths.get(filePath)));

            String regex = "(?:<a href=\")([^\"]+)(?:\"{1})";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(packtDump);

            List<String> links = new ArrayList<>();

            while (matcher.find()) {
                links.add(matcher.group(1));
            }

            System.out.println(links);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
