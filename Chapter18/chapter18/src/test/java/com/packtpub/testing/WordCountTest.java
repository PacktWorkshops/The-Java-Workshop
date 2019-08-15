package com.packtpub.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WordCountTest {

    @ParameterizedTest
    @CsvSource({
        "'A man, a plan, a canal. Panama',  7",
        "'Able was I ere I saw Elba',  7",
        ", 0",
        "'', 0",
        "'   ', 0",
        "' A cat in the hat with spaces   ', 7"
    })
    public void testWordCounts(String text, int expected) {
        WordCount wordCount = new WordCount();

        int count = wordCount.countWords(text);

        Assertions.assertEquals(expected, count,
                "Expected " + expected + " for input[" + text + "]");
    }
}
