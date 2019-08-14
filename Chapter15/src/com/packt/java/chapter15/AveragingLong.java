package com.packt.java.chapter15;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AveragingLong {

    public static void main(String[] args) {

double average = Stream.of(1d, 2d, 3d)
        .collect(Collectors.averagingLong((d) -> { return d.longValue(); }));
System.out.println(average);
    }

}
