package com.packt.java.chapter15;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SummingInt {

    public static void main(String[] args) {

int sum = Stream.of(1d, 2d, 3d)
        .collect(Collectors.summingInt((d) -> { return d.intValue(); }));
System.out.println(sum);
    }

}
