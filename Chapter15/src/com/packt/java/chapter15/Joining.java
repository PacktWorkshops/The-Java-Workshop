package com.packt.java.chapter15;

import java.util.List;
import java.util.stream.Collectors;

public class Joining {

    public static void main(String[] args) {

//        String joined = List.of("one", "two", "three", "four", "five")
//                .stream()
//                .collect(Collectors.joining());
//        System.out.println(joined);

//        String joined = List.of("one", "two", "three", "four", "five")
//                .stream()
//                .collect(Collectors.joining(","));
//        System.out.println(joined);

String joined = List.of("one", "two", "three", "four", "five")
        .stream()
        .collect(Collectors.joining(",", "Prefix", "Suffix"));
System.out.println(joined);

    }

}
