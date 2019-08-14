package com.packt.java.chapter15;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Mapping {

    public static void main(String[] args) {

        Set<String> joined = List.of("one", "two", "three", "four", "five")
                .stream()
                .collect(Collectors.mapping((s) -> { return s + "-suffix"; }, Collectors.toSet()));
        System.out.println(joined);


    }

}
