package com.packt.java.chapter15;

import java.util.stream.Stream;

public class ForEachOrdered {

    public static void main(String[] args) {

        Stream.of(1, 4, 6, 2, 3, 7).parallel().forEachOrdered((n) -> { System.out.println(n); });

    }

}
