package com.packt.java.chapter16;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Activity1 {

    public static void main(String[] args) {
        List<Sensor> sensors = new ArrayList<>();
        sensors.add(new Gateway(34, false));
        sensors.add(new Gateway(44, false));
        sensors.add(new Gateway(74, false));
        sensors.add(new Gateway(56, false));
        sensors.add(new Gateway(18, false));
        sensors.add(new Gateway(92, false));


        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter sensor index:");

        while (scanner.hasNext()) {
            int index = scanner.nextInt();
            if (index < 0) {
                continue;
            }

            System.out.print("Enter (b)attery health or toggle (t)riggered status:");
            String action = scanner.next();

            if (action.toLowerCase().equals("b")) {
                System.out.print("Enter battery health:");
                sensors.get(index).batteryHealth(scanner.nextInt());

            } else if (action.toLowerCase().equals("t")) {
                sensors.get(index).triggered(!sensors.get(index).triggered());
            }

            printAlarmStatus(sensors);

            System.out.print("Enter sensor index:");
        }
    }

    private static void printAlarmStatus(List<Sensor> sensors) {
        Predicate<Sensor> hasAlarmOrWarning = new HasAlarm().or(new HasWarning());

        boolean alarmOrWarning = false;

        for (Sensor sensor : sensors) {
            if (hasAlarmOrWarning.test(sensor)) {
                alarmOrWarning = true;
            }
        }

        if (alarmOrWarning) {
            System.out.println("Alarm, or warning, was triggered!");


            for (Sensor sensor : sensors) {
                System.out.println(sensor.batteryHealth() + ", " + sensor.triggered());
            }
        }
    }

}
