package com.packt.java.chapter15;

import java.util.Optional;
import java.util.stream.Stream;

public class FindAny {

    public static void main(String[] args) {

Optional firstElement = Stream.of(7, 9, 3, 4, 1).findAny();
System.out.println(firstElement);

    }

}
