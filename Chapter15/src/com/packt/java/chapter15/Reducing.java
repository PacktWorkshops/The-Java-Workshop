package com.packt.java.chapter15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reducing {

    public static void main(String[] args) {

Map<String, Optional<Car>> collected = Stream.of(
        new Car("Volvo", 195),
        new Car("Honda", 96),
        new Car("Volvo", 165),
        new Car("Volvo", 165),
        new Car("Honda", 104),
        new Car("Honda", 201),
        new Car("Volvo", 215))
        .collect(Collectors.groupingBy(Car::getBrand, Collectors.reducing((carA, carB) -> {
            if (carA.enginePower > carB.enginePower) {
                return carA;
            }
            return carB;
        })));
System.out.println(collected);
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
