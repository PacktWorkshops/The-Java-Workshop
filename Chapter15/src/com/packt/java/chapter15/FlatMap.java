package com.packt.java.chapter15;

import java.util.List;
import java.util.stream.Stream;

public class FlatMap {

    public static void main(String[] args) {

        Stream.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9))
                .flatMap((l) -> { return l.stream(); })
                .forEach((i) -> { System.out.print(i); });

    }

}
