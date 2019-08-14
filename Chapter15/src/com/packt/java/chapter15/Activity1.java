package com.packt.java.chapter15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Activity1 {

    public static void main(String[] args) {

        ShoppingCart fruitCart = new ShoppingCart(List.of(
                new ShoppingArticle("Orange", 1.5),
                new ShoppingArticle("Apple", 1.7),
                new ShoppingArticle("Banana", 2.2)
        ));

        ShoppingCart vegetableCart = new ShoppingCart(List.of(
                new ShoppingArticle("Cucumber", 0.8),
                new ShoppingArticle("Salad", 1.2),
                new ShoppingArticle("Tomatoes", 2.7)
        ));

        ShoppingCart meatAndFishCart = new ShoppingCart(List.of(
                new ShoppingArticle("Cod", 46.5),
                new ShoppingArticle("Beef", 29.1),
                new ShoppingArticle("Salmon", 35.2)
        ));

        double sum = calculatePrice(fruitCart, vegetableCart, meatAndFishCart);
        System.out.println(String.format("Sum: %.2f", sum));

        Map<String, Double> discounts = Map.of("Cod", 0.2, "Salad", 0.5);

        double sumDiscount = calculatePriceWithDiscounts(discounts, fruitCart, vegetableCart, meatAndFishCart);
        System.out.println(String.format("Discount sum: %.2f", sumDiscount));
    }

    private static double calculatePrice(ShoppingCart... carts) {
        return Stream.of(carts)
                .flatMap((cart) -> { return cart.mArticles.stream(); })
                .mapToDouble((item) -> { return item.price; })
                .sum();
    }

    private static final class ShoppingCart {
        final List<ShoppingArticle> mArticles;

        public ShoppingCart(List<ShoppingArticle> list) {
            mArticles = List.copyOf(list);
        }
    }

    private static final class ShoppingArticle {
        final String name;
        final double price;

        public ShoppingArticle(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    private static double calculatePriceWithDiscounts(Map<String, Double> discounts, ShoppingCart... carts) {
        return Stream.of(carts)
                .flatMap((cart) -> { return cart.mArticles.stream(); })
                .mapToDouble((item) -> {
                    if (discounts.containsKey(item.name)) {
                        return item.price - item.price * discounts.get(item.name);
                    }
                    return item.price;
                })
                .sum();
    }
}
