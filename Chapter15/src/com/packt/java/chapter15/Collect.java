package com.packt.java.chapter15;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class Collect {

    public static void main(String[] args) {

        List<Integer> items = Stream.of(6, 3, 8, 12, 3, 9).collect(Collectors.toList());
        System.out.println(items);

        List<Integer> items2 = Stream.of(6, 3, 8, 12, 3, 9).collect(ArrayList::new, List::add, List::addAll);
        System.out.println(items);

        List<Integer> items3 = Stream.of(6, 3, 8, 12, 3, 9).collect(
                () -> { return new ArrayList<Integer>(); },
                (list, i) -> { list.add(i); },
                (list, elements) -> { list.addAll(elements); });
        System.out.println(items);

    }

}
