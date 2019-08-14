package com.packt.java.chapter15;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Boxed {

    public static void main(String[] args) {

        IntStream.of(1, 2)
                .boxed()
                .forEach((i) -> { System.out.println(i + i.getClass().getSimpleName()); });

        System.out.println();

        LongStream.of(1, 2)
                .boxed()
                .forEach((l) -> { System.out.println(l + l.getClass().getSimpleName()); });

        System.out.println();

        DoubleStream.of(1, 2)
                .boxed()
                .forEach((d) -> { System.out.println(d + d.getClass().getSimpleName()); });

    }

}
