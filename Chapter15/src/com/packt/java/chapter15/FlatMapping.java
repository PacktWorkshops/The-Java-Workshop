package com.packt.java.chapter15;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapping {

    public static void main(String[] args) {

        List<String> joined = List.of(
                Set.of("one", "two", "three"),
                Set.of("four", "five"),
                Set.of("six")
        )
                .stream()
                .collect(Collectors.flatMapping(
                        (set) -> { return set.stream(); },
                        Collectors.toList())
                );
        System.out.println(joined);


    }

}
