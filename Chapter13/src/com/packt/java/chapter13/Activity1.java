package com.packt.java.chapter13;

import java.util.ArrayList;
import java.util.List;

public class Activity1 {

    public static void main(String[] args) {
        System.out.println(sum(2, 3));
        System.out.println(sum(2, 3));
        System.out.println(sum(2, 3));

        System.out.println(sum(List.of(1, 2, 3)));
        System.out.println(sum(List.of(1, 2, 3)));
        System.out.println(sum(List.of(1, 2, 3)));

        System.out.println(sum(2, 3, 4));
        System.out.println(sum(2, 3, 4));
        System.out.println(sum(2, 3, 4));
    }

    static int sum(int price1, int price2) {
        return price1 + price2;
    }

    static int sum(List<Integer> prices) {
        int sum = 0;
        for (int price : prices) {
            sum += price;
        }
        return sum;
    }

    static int sum(int... prices) {
        int sum = 0;
        for (int price : prices) {
            sum += price;
        }
        return sum;
    }
}