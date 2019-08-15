package com.packtpub.chapter06;

public class Example02 {
    public static void main(String[] args) {
        java.time.LocalDateTime localDateTime = java.time.LocalDateTime.now();

        java.time.DayOfWeek day = localDateTime.getDayOfWeek();

        System.out.println("The week day is: " + day);
    }
}
