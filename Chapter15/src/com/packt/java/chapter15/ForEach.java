package com.packt.java.chapter15;

import java.util.stream.Stream;

public class ForEach {

    public static void main(String[] args) {

//        Stream.of(1, 4, 6, 2, 3, 7).forEach((n) -> { System.out.println(n); });

        Stream.of(1, 4, 6, 2, 3, 7).parallel().forEach((n) -> { System.out.println(n); });

    }

}
