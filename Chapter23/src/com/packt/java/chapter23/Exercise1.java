package com.packt.java.chapter23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise1 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        service.execute(new BubbleSort(5, 2, 1, 3, 7, 9, 6, 4, 8, 10));

        service.shutdown();
    }
}
