package com.packt.java.chapter12;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Activity2 {

    public static void main(String[] args) {

        String filePath = System.getProperty("user.dir") + File.separator + "res" + File.separator + "packt.txt";
        try {
            String packtDump = new String(Files.readAllBytes(Paths.get(filePath)));

            String regex = "(?:<a href=\")(?!http[s]?:/)(?![#])(?:[^\"])([^\"]+)(?:\")";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(packtDump);

            List<String> links = new ArrayList<>();

            while (matcher.find()) {
                links.add(matcher.group(1));
            }

            Map<String, Integer> groups = new HashMap<>();

            for (String link : links) {
                String group = link;
                if (link.contains("/")) {
                    group = link.substring(0, link.indexOf("/"));
                }

                if (!groups.containsKey(group)) {
                    groups.put(group, 0);
                }

                int value = groups.get(group) + 1;
                groups.put(group, value);
            }

            System.out.println(links);
            System.out.println(groups);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
