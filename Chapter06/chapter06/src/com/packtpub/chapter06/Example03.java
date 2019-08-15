package com.packtpub.chapter06;

import java.time.*;

public class Example03 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();

        DayOfWeek day = localDateTime.getDayOfWeek();

        System.out.println("The week day is: " + day);
    }
}
