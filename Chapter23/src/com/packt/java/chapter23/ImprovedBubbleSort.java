package com.packt.java.chapter23;

import java.util.Arrays;

public class ImprovedBubbleSort implements Runnable {

    private int[] data;

    public ImprovedBubbleSort(int... values) {
        this.data = values;
    }

    @Override
    public void run() {
        System.out.println(Arrays.toString(data));
        int n = data.length;
        int passes = 0;
        for (int i = 1; i < n; i++) {
            passes++;
            for (int j = 0; j < n - i; i++) {
                int currentItem = data[j];
                int nextItem = data[j + 1];

                if (currentItem > nextItem) {
                    data[j] = nextItem;
                    data[j + 1] = currentItem;
                }
            }
        }
        System.out.println(Arrays.toString(data));
        System.out.println("Passes: " + passes);
    }
}
