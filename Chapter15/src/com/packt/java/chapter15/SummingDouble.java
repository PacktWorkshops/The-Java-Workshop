package com.packt.java.chapter15;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SummingDouble {

    public static void main(String[] args) {

double sum = Stream.of(1, 2, 3)
        .collect(Collectors.summingDouble((i) -> { return i.doubleValue(); }));
System.out.println(sum);
    }

}
