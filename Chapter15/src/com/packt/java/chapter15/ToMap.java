package com.packt.java.chapter15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ToMap {

    public static void main(String[] args) {

//        Map<String, Integer> mapped = List.of("1", "2", "3", "4", "5")
//                .stream()
//                .collect(Collectors.toMap((s) -> {
//                    return s;
//                }, (s) -> {
//                    return Integer.valueOf(s);
//                }));
//        System.out.println(mapped);

//        Map<String, Integer> mapped = List.of("1", "2", "3", "4", "5", "1", "2")
//                .stream()
//                .collect(Collectors.toMap((s) -> {
//                    return s;
//                }, (s) -> {
//                    return Integer.valueOf(s);
//                }, (a, b) -> {
//                    return Integer.valueOf(b);
//                }));
//        System.out.println(mapped);

TreeMap<String, Integer> mapped = List.of("1", "2", "3", "4", "5", "1", "2")
        .stream()
        .collect(Collectors.toMap((s) -> {
            return s;
        }, (s) -> {
            return Integer.valueOf(s);
        }, (a, b) -> {
            return Integer.valueOf(b);
        }, () -> {
            return new TreeMap<>();
        }));
System.out.println(mapped);

    }

}
