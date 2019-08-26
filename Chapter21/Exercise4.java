package com.packt.java.chapter21;

import java.lang.ref.SoftReference;

public class Exercise4 {

    public static void main(String[] args) {

        ShoppingCart shoppingCart = new ShoppingCart();

        SoftReference<ShoppingCart> softReference = new SoftReference<>(shoppingCart);

        shoppingCart = null;

        try {
            // Also set the maximum heap to
            ShoppingCart[] ignored = new ShoppingCart[(int) Runtime.getRuntime().maxMemory()];
        } catch (OutOfMemoryError e) {}

        System.gc();

        ShoppingCart shoppingCart2 = softReference.get();

        System.out.println(String.format("ShoppingCart was %scleared.", (shoppingCart2 == null ? "" : "not ")));
    }
}