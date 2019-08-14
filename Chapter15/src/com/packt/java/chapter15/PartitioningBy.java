package com.packt.java.chapter15;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitioningBy {

    public static void main(String[] args) {

//Map<Boolean, List<Car>> partitioned = Stream.of(
//        new Car("Toyota", 92),
//        new Car("Kia", 104),
//        new Car("Huyndai", 89),
//        new Car("Toyota", 116),
//        new Car("Mercedes", 209))
//        .collect(Collectors.partitioningBy((car) -> { return car.enginePower > 100; }));
//System.out.println(partitioned);

Map<Boolean, Set<Car>> partitioned = Stream.of(
        new Car("Toyota", 92),
        new Car("Kia", 104),
        new Car("Huyndai", 89),
        new Car("Toyota", 116),
        new Car("Mercedes", 209))
        .collect(Collectors.partitioningBy((car) -> { return car.enginePower > 100; }, Collectors.toSet()));
System.out.println(partitioned);

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
}

}
