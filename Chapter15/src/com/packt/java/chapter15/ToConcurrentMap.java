package com.packt.java.chapter15;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class ToConcurrentMap {

    public static void main(String[] args) {

ConcurrentMap<String, Integer> mapped = List.of("1", "2", "3", "4", "5")
        .stream()
        .collect(Collectors.toConcurrentMap((s) -> {
            return s;
        }, (s) -> {
            return Integer.valueOf(s);
        }));
System.out.println(mapped);

//ConcurrentMap<String, Integer> mapped = List.of("1", "2", "3", "4", "5", "1", "2")
//        .stream()
//        .collect(Collectors.toConcurrentMap((s) -> {
//            return s;
//        }, (s) -> {
//            return Integer.valueOf(s);
//        }, (a, b) -> {
//            return Integer.valueOf(b);
//        }));
//System.out.println(mapped);

//ConcurrentHashMap<String, Integer> mapped = List.of("1", "2", "3", "4", "5", "1", "2")
//        .stream()
//        .collect(Collectors.toConcurrentMap((s) -> {
//            return s;
//        }, (s) -> {
//            return Integer.valueOf(s);
//        }, (a, b) -> {
//            return Integer.valueOf(b);
//        }, () -> {
//            return new ConcurrentHashMap<>();
//        }));
//System.out.println(mapped);

    }

}
