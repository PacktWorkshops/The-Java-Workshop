package com.packt.java.chapter15;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Filtering {

    public static void main(String[] args) {

Set<String> joined = List.of("Andreas", "David", "Eric")
        .stream()
        .collect(Collectors.filtering(
                (name) -> { return name.length() < 6; },
                Collectors.toSet())
        );
System.out.println(joined);


    }

}
