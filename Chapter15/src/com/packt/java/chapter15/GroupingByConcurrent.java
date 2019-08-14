package com.packt.java.chapter15;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByConcurrent {

    public static void main(String[] args) {

        Map<String, List<Car>> grouped = Stream.of(
                new Car("Toyota"),
                new Car("Huyndai"),
                new Car("Kia"),
                new Car("Toyota"))
                .collect(Collectors.groupingByConcurrent(Car::getBrand));
        System.out.println(grouped);

    }

private static class Car {
    String brand;
    Car(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}

}
