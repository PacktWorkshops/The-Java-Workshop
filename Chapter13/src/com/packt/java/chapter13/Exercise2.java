package com.packt.java.chapter13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise2 {

    public static void main(String[] args) {
        ShoppingCart myFirstCart = new ShoppingCart(new ArrayList<ShoppingItem>());
        ShoppingCart mySecondCart = myFirstCart.addItem(new ShoppingItem("Chair", 150));
        ShoppingCart myThirdCart = mySecondCart.addItem(new ShoppingItem("Table",350));
    }

    private static final class ShoppingItem {
        private final String name;
        private final int price;

        public ShoppingItem(String name, int price) {
            this.name = name;
            this.price = price;
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
    }
}


