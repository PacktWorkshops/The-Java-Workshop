package com.packt.java.chapter15;

import java.util.stream.Stream;

public class Count {

    public static void main(String[] args) {

        long count = Stream.of(6, 3, 8, 12, 3, 9).count();
        System.out.println(count);

    }

}
