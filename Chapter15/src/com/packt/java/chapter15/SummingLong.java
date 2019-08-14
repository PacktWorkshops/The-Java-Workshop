package com.packt.java.chapter15;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SummingLong {

    public static void main(String[] args) {

long sum = Stream.of(1d, 2d, 3d)
        .collect(Collectors.summingLong((d) -> { return d.longValue(); }));
System.out.println(sum);
    }

}
