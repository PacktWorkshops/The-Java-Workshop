package com.packt.java.chapter21;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class Activity1 {

    public static void main(String[] args) throws InterruptedException {
        ShoppingCart shoppingCart1 = new ShoppingCart();
        ShoppingCart shoppingCart2 = new ShoppingCart();
        ShoppingCart shoppingCart3 = new ShoppingCart();

        ReferenceQueue<ShoppingCart> referenceQueue = new ReferenceQueue<>();

        WeakReference<ShoppingCart> weakReference1 = new WeakReference<>(shoppingCart1, referenceQueue);
        WeakReference<ShoppingCart> weakReference2 = new WeakReference<>(shoppingCart2, referenceQueue);
        WeakReference<ShoppingCart> weakReference3 = new WeakReference<>(shoppingCart3, referenceQueue);

        System.out.println(String.format("Reference queue does %scontain references", (referenceQueue.poll() == null ? "not " : "")));

        shoppingCart1 = null;
        shoppingCart2 = null;
        shoppingCart3 = null;

        System.gc();

        Thread.sleep(1);

        WeakReference<ShoppingCart> shoppingCartReferece = null;
        while ((shoppingCartReferece = (WeakReference<ShoppingCart>) referenceQueue.poll()) != null) {
            System.out.println(String.format("Reference was %scleared", shoppingCartReferece.get() == null ? "": "not "));
        }

    }
}