package com.packt.java.chapter13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) {
        List<ShoppingItem> books = new ArrayList<>();
        books.add(new ShoppingItem("Java Fundamentals", 100));
        books.add(new ShoppingItem("Java 11 Quick Start", 200));

        List<ShoppingItem> immutableCopy = List.copyOf(books);
        List<ShoppingItem> unmodifiableCopy = Collections.unmodifiableList(books);

        System.out.println(immutableCopy);
        System.out.println(unmodifiableCopy);

        books.remove(0);
        System.out.println(immutableCopy);
        System.out.println(unmodifiableCopy);
    }

    private static final class ShoppingItem {
        private final String name;
        private final int price;

        public ShoppingItem(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return name + ", " + price;
        }
    }

    public static final class ShoppingCart {

        public final List<ShoppingItem> mShoppingList;

        public ShoppingCart(List<ShoppingItem> list) {
            mShoppingList = Collections.unmodifiableList(list);
        }

        public ShoppingCart addItem(ShoppingItem item) {
            List<ShoppingItem> newList = new ArrayList<>(mShoppingList);
            newList.add(item);
            return new ShoppingCart(newList);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Cart: ");
            for (int i = 0; i < mShoppingList.size(); i++) {
                sb.append(mShoppingList.get(i)).append(", ");
            }
            return sb.toString();
        }
    }
}


