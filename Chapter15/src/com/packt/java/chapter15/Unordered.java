package com.packt.java.chapter15;

import java.util.stream.Stream;

public class Unordered {

    public static void main(String[] args) {

Stream.of(1, 2, 3, 4, 5, 6)
        .unordered()
        .forEach((i) -> { System.out.print(i); });

System.out.println();

Stream.of(1, 2, 3, 4, 5, 6)
        .parallel()
        .unordered()
        .forEach((i) -> { System.out.print(i); });

    }

}
