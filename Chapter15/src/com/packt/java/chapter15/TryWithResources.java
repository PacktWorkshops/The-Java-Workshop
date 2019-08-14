package com.packt.java.chapter15;

import java.util.stream.Stream;

public class TryWithResources {

    public static void main(String[] args) {

        try (Stream<Integer> stream = Stream.of(6, 3, 8, 12, 3, 9)) {
            boolean matched = stream.onClose(() -> {
                System.out.println("Closed");
            }).anyMatch((e) -> {
                return e > 10;
            });
            System.out.println(matched);
        }

    }

}
