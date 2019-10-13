package com.packt.java.chapter21;

import java.lang.ref.SoftReference;

public class Exercise4 {

    public static void main(String[] args) {

        ShoppingCart shoppingCart = new ShoppingCart();

        SoftReference<ShoppingCart> softReference = new SoftReference<>(shoppingCart);

        shoppingCart = null;

        try {
            // Attempt to fill up the HEAP to maximum
            ShoppingCart[] ignored = new ShoppingCart[(int) Runtime.getRuntime().maxMemory()];
        } catch (OutOfMemoryError e) {
        }

        System.gc();

        System.runFinalization();

        ShoppingCart shoppingCart2 = softReference.get();

        System.out.println(String.format("ShoppingCart was %scleared.", (shoppingCart2 == null ? "" : "not ")));
    }
}