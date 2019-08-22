package com.packt.java.chapter21;

import java.lang.ref.SoftReference;

public class Activity4 {

    public static void main(String[] args) throws InterruptedException {

        ShoppingCart shoppingCart = new ShoppingCart();

        SoftReference<ShoppingCart> softReference = new SoftReference<>(shoppingCart);

        for (int i = 0; i < 1_000_000; i++) {
            Student asd = new Student("asd");
        }

        shoppingCart = null;


        ShoppingCart shoppingCart2 = softReference.get();

        System.out.println(String.format("ShoppingCart was %scleared.", (shoppingCart2 == null ? "" : "not ")));
    }
}