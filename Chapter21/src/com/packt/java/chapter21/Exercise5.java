package com.packt.java.chapter21;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class Exercise5 {

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        ReferenceQueue<ShoppingCart> referenceQueue = new ReferenceQueue<>();

        PhantomReference<ShoppingCart> phantomReference = new PhantomReference<>(shoppingCart, referenceQueue);

        System.out.println("ShoppingCart acquired from reference: " + phantomReference.get());

        System.out.println("Queue is empty? " + (null == referenceQueue.poll()));

        // Start the listener, this will clear the memory when needed!
        new Thread(new PhantomListener(phantomReference, referenceQueue)).start();

        shoppingCart = null;

        for (int i = 0; i < 1000; i++) {
            double[] garbage = new double[1_000_000];
        }
    }

    private static class PhantomListener implements Runnable {

        PhantomReference reference;
        ReferenceQueue referenceQueue;

        public PhantomListener(PhantomReference reference, ReferenceQueue referenceQueue) {
            this.reference = reference;
            this.referenceQueue = referenceQueue;
        }

        @Override
        public void run() {
            while (!reference.isEnqueued()) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Reference was enqueued!");

            customFinalization();

            Reference polledReference = referenceQueue.poll();
            polledReference.clear();
        }

        private void customFinalization() {
            System.out.println("Running custom finalization logic.");
        }
    }
}
