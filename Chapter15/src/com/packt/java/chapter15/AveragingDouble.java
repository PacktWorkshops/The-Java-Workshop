package com.packt.java.chapter15;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AveragingDouble {

    public static void main(String[] args) {

double average = Stream.of(1, 2, 3)
        .collect(Collectors.averagingDouble((i) -> { return i.doubleValue(); }));
System.out.println(average);
    }

}
