package com.packt.java.chapter23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Activity1 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.execute(new BubbleSort(5, 1, 2, 4, 3, 6));
        service.execute(new ImprovedBubbleSort(5, 1, 2, 4, 3, 6));

        service.execute(new BubbleSort(1, 3, 2, 5, 4, 7));
        service.execute(new ImprovedBubbleSort(1, 3, 2, 5, 4, 7));

        service.shutdown();
    }
}