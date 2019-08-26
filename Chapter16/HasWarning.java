package com.packt.java.chapter16;

import java.util.function.Predicate;

public class HasWarning implements Predicate<Sensor> {

    public static final int BATTERY_WARNING = 10;

    @Override
    public boolean test(Sensor sensor) {
        return sensor.batteryHealth() < BATTERY_WARNING;
    }

}
