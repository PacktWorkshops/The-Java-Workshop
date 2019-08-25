package com.packt.java.chapter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Activity3 {

    public static void main(String[] args) {
        List<Sensor> sensors = new ArrayList<>();
        sensors.add(new Gateway(34, false));
        sensors.add(new Gateway(14, true));
        sensors.add(new Fire(78, false, 21));
        sensors.add(new Gateway(74, false));
        sensors.add(new Gateway(8, false));
        sensors.add(new Movement(87, false, 45));
        sensors.add(new Gateway(18, false));
        sensors.add(new Fire(32, false, 23));
        sensors.add(new Gateway(9, false));
        sensors.add(new Movement(76, false, 41));

        Function<Sensor, Integer> extractBatteryHealth = sensor -> sensor.batteryHealth();

        Integer[] batteryHealths = sensors.stream().map(extractBatteryHealth).toArray(Integer[]::new);

        System.out.println(Arrays.toString(batteryHealths));

        System.out.println(loopedAverageHealth(batteryHealths));

        System.out.println(streamedAverageHealth(batteryHealths));

        System.out.println(recursiveAverageHealth(batteryHealths, batteryHealths.length - 1));
    }

    private static double loopedAverageHealth(Integer[] batteryHealths) {
        double average = 0;
        for (int i = 0; i < batteryHealths.length; i++) {
            average += batteryHealths[i];
        }
        average = average / batteryHealths.length;
        return average;
    }

    private static double streamedAverageHealth(Integer[] batteryHealths) {
        return Stream.of(batteryHealths)
                .mapToDouble(Integer::intValue)
                .average()
                .orElse(0);
    }

    private static double recursiveAverageHealth(Integer[] batteryHealths, int index) {
        double average = batteryHealths[index] / (double) batteryHealths.length;
        if (index == 0) {
            return average;
        } else {
            return average + recursiveAverageHealth(batteryHealths, index - 1);
        }
    }
}
