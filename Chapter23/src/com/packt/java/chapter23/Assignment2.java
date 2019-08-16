package com.packt.java.chapter23;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Assignment2 {

    public static void main(String[] args) {
        int[] data = new int[10000];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 100000);
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int[] sorted = forkJoinPool.invoke(new MergeSort(data));

        System.out.println(Arrays.toString(sorted));
    }
}
