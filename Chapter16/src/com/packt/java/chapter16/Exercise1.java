package com.packt.java.chapter16;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Exercise1 {

    public static void main(String[] args) {
        List<Sensor> sensors = new ArrayList<>();
        sensors.add(new Gateway(34, false));
        sensors.add(new Gateway(14, true));
        sensors.add(new Gateway(74, false));
        sensors.add(new Gateway(8, false));
        sensors.add(new Gateway(18, false));
        sensors.add(new Gateway(9, false));

        Predicate<Sensor> hasAlarmOrWarning = new HasAlarm().or(new HasWarning());

        for (Sensor sensor : sensors) {
            if (new HasAlarm().test(sensor)) {
                System.out.println("Alarm was triggered");
            }

            if (hasAlarmOrWarning.test(sensor)) {
                System.out.println("Alarm or warning was triggered");
            }
        }
    }
}
