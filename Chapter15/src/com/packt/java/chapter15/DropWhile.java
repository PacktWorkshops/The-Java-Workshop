package com.packt.java.chapter15;

import java.util.stream.Stream;

public class DropWhile {

    public static void main(String[] args) {

        Stream.of(2, 2, 2, 3, 1, 2, 5)
                .dropWhile((i) -> { return i == 2; })
                .forEach((i) -> { System.out.print(i); });

        System.out.println();

        Stream.of(2, 2, 2, 3, 1, 2, 5)
                .unordered()
                .dropWhile((i) -> { return i == 2; })
                .forEach((i) -> { System.out.print(i); });

    }

}
