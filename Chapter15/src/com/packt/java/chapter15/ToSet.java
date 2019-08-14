package com.packt.java.chapter15;

import java.util.List;
import java.util.stream.Collectors;

public class ToSet {

    public static void main(String[] args) {

List.of("one", "two", "three", "four", "five")
        .stream()
        .collect(Collectors.toSet());

    }

}
