package com.packt.java.chapter15;

import java.util.Optional;
import java.util.stream.Stream;

public class Min {

    public static void main(String[] args) {

        Optional min = Stream.of(6, 3, 8, 12, 3, 9).min((a, b) -> { return a - b;});
        System.out.println(min);

    }

}
