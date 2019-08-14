package com.packt.java.chapter15;

import java.util.List;
import java.util.stream.Stream;

public class Assignment2 {

    public static void main(String[] args) {

        ShoppingCart fruitCart = new ShoppingCart(List.of(
                new ShoppingArticle("Orange", 1.5, 2),
                new ShoppingArticle("Apple", 1.7, 1),
                new ShoppingArticle("Banana", 2.2, 1)
        ));

        ShoppingCart vegetableCart = new ShoppingCart(List.of(
                new ShoppingArticle("Cucumber", 0.8, 1),
                new ShoppingArticle("Salad", 1.2, 1),
                new ShoppingArticle("Tomatoes", 2.7, 1)
        ));

        ShoppingCart meatAndFishCart = new ShoppingCart(List.of(
                new ShoppingArticle("Cod", 46.5, 1),
                new ShoppingArticle("Beef", 29.1, 1),
                new ShoppingArticle("Salmon", 35.2, 1)
        ));

        double sum = calculatePrice(mergeShoppingCarts(fruitCart, vegetableCart, meatAndFishCart));
        System.out.println(String.format("Total sum: %.2f", sum));

        double sumDiscount = calculatePriceWithDiscounts(mergeShoppingCarts(fruitCart, vegetableCart, meatAndFishCart),
                new ShoppingArticleDiscount("Banana", 0.2),
                new ShoppingArticleDiscount("Salmon", 0.8));

        System.out.println(String.format("Discount sum: %.2f", sumDiscount));
    }

    private static Stream<ShoppingArticle> mergeShoppingCarts(ShoppingCart... shoppingCarts) {
        return Stream.of(shoppingCarts)
                .flatMap((cart) -> { return cart.mArticles.stream(); });
    }

    private static double calculatePriceWithDiscounts(Stream<ShoppingArticle> stream, ShoppingArticleDiscount... discounts) {
        return calculatePrice(stream.map((item) -> {
            for (ShoppingArticleDiscount discount : discounts) {
                if (item.name.equals(discount.name)) {
                    return new ShoppingArticle(item.name, item.price * discount.priceModification, item.quantity);
                }
            }
            return item;
        }));
    }

    private static double calculatePrice(Stream<ShoppingArticle> stream) {
        return stream.mapToDouble((item) -> { return item.price * item.quantity; })
                .sum();
    }

    private static final class ShoppingCart{
        final List<ShoppingArticle> mArticles;

        public ShoppingCart(List<ShoppingArticle> list) {
            mArticles = List.copyOf(list);
        }
    }

    private static final class ShoppingArticle {
        final String name;
        final double price;
        final int quantity;

        public ShoppingArticle(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
    }

    private static final class ShoppingArticleDiscount {
        final String name;
        final double priceModification;
        public ShoppingArticleDiscount(String name, double priceModification) {
            this.name = name;
            this.priceModification = priceModification;
        }
    }
}
