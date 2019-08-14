package com.packt.java.chapter15;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectingAndThen {

    public static void main(String[] args) {

Set<String> immutableSet = List.of("Andreas", "David", "Eric")
        .stream()
        .collect(Collectors.collectingAndThen(
                Collectors.toSet(),
                (set) -> { return Collections.unmodifiableSet(set); })
        );
System.out.println(immutableSet);


    }

}
