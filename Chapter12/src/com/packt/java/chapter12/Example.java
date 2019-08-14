package com.packt.java.chapter12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example {

    public static void main(String[] args) {

        System.out.println(Pattern.matches("a+", "How much wood would a woodchuck chuck if a woodchuck could chuck wood?"));
    }
}
