package com.packt.java.chapter15;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Sum {

    public static void main(String[] args) {

        int intSum = IntStream.of(1, 7, 4, 3, 9, 6).sum();
        System.out.println(intSum);

        long longSum = LongStream.of(7L, 4L, 9L, 2L).sum();
        System.out.println(longSum);

        double doubleSum = DoubleStream.of(5.4, 1.9, 7.2, 6.1).sum();
        System.out.println(doubleSum);

    }

}
