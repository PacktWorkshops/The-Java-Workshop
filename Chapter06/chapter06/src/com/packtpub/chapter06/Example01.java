package com.packtpub.chapter06;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Example01 {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();

        DayOfWeek day = localDateTime.getDayOfWeek();

        System.out.println("The week day is: " + day);
    }
}
