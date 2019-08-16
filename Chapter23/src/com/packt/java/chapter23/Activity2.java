package com.packt.java.chapter23;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Activity2 {

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int[] result = forkJoinPool.invoke(new ImprovedMergeSort(1, 4, 7, 3, 5, 9, 12, 54, 32, 3, 2, 87, 24));

        System.out.println(Arrays.toString(result));
    }
}
