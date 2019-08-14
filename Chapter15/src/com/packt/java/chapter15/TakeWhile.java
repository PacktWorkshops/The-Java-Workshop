package com.packt.java.chapter15;

import java.util.stream.Stream;

public class TakeWhile {

    public static void main(String[] args) {

        Stream.of(2, 2, 2, 3, 1, 2, 5)
                .takeWhile((i) -> { return i == 2; })
                .forEach((i) -> { System.out.print(i); });

        System.out.println();

        Stream.of(2, 1, 2, 2, 3, 3, 2, 3, 3, 1, 2, 5)
                .unordered()
                .takeWhile((i) -> { return i == 3; })
                .forEach((i) -> { System.out.print(i); });

    }

}
