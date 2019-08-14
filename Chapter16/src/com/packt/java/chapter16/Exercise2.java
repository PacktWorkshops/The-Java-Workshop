package com.packt.java.chapter16;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Exercise2 {

    static boolean alarmServiceNotified;

    public static void main(String[] args) {
        List<Sensor> sensors = new ArrayList<>();
        sensors.add(new Gateway(34, false));
        sensors.add(new Gateway(14, true));
        sensors.add(new Gateway(74, false));
        sensors.add(new Gateway(8, false));
        sensors.add(new Gateway(18, false));
        sensors.add(new Gateway(9, false));

        Predicate<Sensor> hasAlarmOrWarning = new HasAlarm().or(new HasWarning());

        if (sensors.stream().anyMatch(hasAlarmOrWarning)) {
            System.out.println("Alarm or warning was triggered");
        }

        SendAlarm sendAlarm = new SendAlarm();

        ResetAlarm resetAlarm = new ResetAlarm();

        sensors.stream().filter(hasAlarmOrWarning).forEach(sendAlarm.andThen(resetAlarm));

        if (alarmServiceNotified) {
            System.out.println("Alarm service notified");
        }

        if (sensors.stream().anyMatch(hasAlarmOrWarning.negate())) {
            System.out.println("Nothing was triggered");
        }
    }
}
