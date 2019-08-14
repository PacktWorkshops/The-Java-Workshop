package com.packt.java.chapter15;

import java.util.List;
import java.util.stream.Stream;

public class Assignment1 {

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

        Stream<ShoppingArticle> articleStream = mergeShoppingCarts(fruitCart, vegetableCart, meatAndFishCart);

        double sum = calculatePrice(articleStream);
        System.out.println(String.format("Total sum: %.2f", sum));

        double sumDiscount = calculatePriceWithDiscounts(articleStream,
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
                    return new ShoppingArticle(item.name, item.price * discount.priceModification);
                }
            }
            return item;
        }));
    }

    private static double calculatePrice(Stream<ShoppingArticle> stream) {
        return stream.mapToDouble((item) -> { return item.price; })
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

        public ShoppingArticle(String name, double price) {
            this.name = name;
            this.price = price;
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
