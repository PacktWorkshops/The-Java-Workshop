package com.packtpub.message;

import com.packtpub.day.Today;

public class Message {
    public static void main(String[] args) {
        Today today = new Today();
        System.out.println("Today is " + today.getToday());
    }
}
