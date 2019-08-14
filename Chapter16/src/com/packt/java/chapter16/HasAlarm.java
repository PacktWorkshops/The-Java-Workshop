package com.packt.java.chapter16;

import java.util.function.Predicate;

public class HasAlarm implements Predicate<Sensor> {

    @Override
    public boolean test(Sensor sensor) {
        return sensor.triggered();
    }

}
