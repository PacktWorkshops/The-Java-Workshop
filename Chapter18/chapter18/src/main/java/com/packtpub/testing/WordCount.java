package com.packtpub.testing;

public class WordCount {
    public int countWords(String text) {

        int count = 0;
        if (text != null) {
            String trimmed = text.trim();

            if (trimmed.length() > 0) {
                String[] words = trimmed.split("\\s+");
                count = words.length;
            }
        }

        return count;
    }
}
