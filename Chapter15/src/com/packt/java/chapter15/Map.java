package com.packt.java.chapter15;

import java.util.stream.Stream;

public class Map {

    public static void main(String[] args) {

        Stream.of("5", "3", "8", "2")
                .map((s) -> { return Integer.parseInt(s); })
                .forEach((i) -> { System.out.println(i > 3); });

        Stream.of("5", "3", "8", "2")
                .mapToInt((i) -> { return Integer.parseInt(i); })
                .forEach((i) -> { System.out.println(i > 3); });
    }

}
