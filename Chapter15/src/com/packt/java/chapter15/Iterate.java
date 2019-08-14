package com.packt.java.chapter15;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Iterate {

    public static void main(String[] args) {
Stream.iterate(0, (i) -> {
    return i + 1;
}).limit(5).forEach((i) -> {
    System.out.println(i);
});
    }

}
