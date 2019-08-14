package com.packt.java.chapter15;

import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sumarizing {

    public static void main(String[] args) {

LongSummaryStatistics statistics = Stream.of(
        new Car("Volvo", 165),
        new Car("Volvo", 165),
        new Car("Honda", 104),
        new Car("Honda", 201)
).collect(Collectors.summarizingLong((e) -> {
    return e.enginePower;
}));
System.out.println(statistics);

    }

    private static class Car {
        String brand;
        long enginePower;
        Car(String brand, long enginePower) {
            this.brand = brand;
            this.enginePower = enginePower;
        }

        public String getBrand() {
            return brand;
        }

        @Override
        public String toString() {
            return brand + ": " + enginePower;
        }
    }
}
