package com.packt.java.chapter15;

import java.util.stream.Stream;

public class Reduce {

    public static void main(String[] args) {

        int sum = Stream.of(1, 7, 4, 3, 9, 6).reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int sum2 = Stream.of(1, 7, 4, 3, 9, 6).reduce(0, (total, i) -> total + i, (a, b) -> a + b );
        System.out.println(sum2);

    }

}
