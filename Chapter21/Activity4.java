package com.packt.java.chapter21;

import java.lang.ref.SoftReference;

public class Activity4 {

    public static void main(String[] args) throws InterruptedException {

        ShoppingCart shoppingCart = new ShoppingCart();

        SoftReference<ShoppingCart> softReference = new SoftReference<>(shoppingCart);

        // Also set the maximum heap size using VM option -XmX2M (maximum heap to 2MB)
        for (int i = 0; i < 1_000_000; i++) {
            Student student = new Student("student");
        }

        shoppingCart = null;


        ShoppingCart shoppingCart2 = softReference.get();

        System.out.println(String.format("ShoppingCart was %scleared.", (shoppingCart2 == null ? "" : "not ")));
    }
}