package com.packt.java.chapter15;

import java.util.stream.Stream;

public class Sorted {

    public static void main(String[] args) {

        Stream.of(1, 3, 6, 4, 5, 2)
                .sorted()
                .forEach((i) -> { System.out.print(i); });

        System.out.println();

        Stream.of(1, 3, 6, 4, 5, 2)
                .sorted((a, b) -> a - b)
                .forEach((i) -> { System.out.print(i); });

    }

}
