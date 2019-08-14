package com.packt.java.chapter15;

import java.util.stream.Stream;

public class Limit {

    public static void main(String[] args) {

        Stream.of(1, 2, 3, 4, 5, 6)
                .limit(3)
                .forEach((i) -> { System.out.print(i); });

    }

}
