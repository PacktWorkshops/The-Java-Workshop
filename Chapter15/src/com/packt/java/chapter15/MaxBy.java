package com.packt.java.chapter15;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxBy {

    public static void main(String[] args) {

Optional<Integer> smallest = Stream.of(1, 2, 3)
        .collect(Collectors.maxBy((a, b) -> { return a - b; }));
System.out.println(smallest);

    }

}
