package com.packt.java.chapter15;

import java.util.List;
import java.util.stream.Collectors;

public class Counting {

    public static void main(String[] args) {

long count = List.of("Andreas", "David", "Eric")
        .stream()
        .collect(Collectors.counting());
System.out.println(count);


    }

}
