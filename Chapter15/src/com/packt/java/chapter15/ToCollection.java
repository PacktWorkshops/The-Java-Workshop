package com.packt.java.chapter15;

import java.util.*;
import java.util.stream.Collectors;

public class ToCollection {

    public static void main(String[] args) {

        List.of("one", "two", "three", "four", "five")
                .stream()
                .collect(Collectors.toCollection(TreeSet::new));

    }

}
