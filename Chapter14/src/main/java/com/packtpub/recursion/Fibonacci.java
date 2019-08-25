package com.packtpub.recursion;

public class Fibonacci {

    // Gnerates the value for this number
    public static int fibonacci(int number) {
        if (number == 0) {
            return number;
        } else if (number == 1) {
            return 1;
        } else {
            return (fibonacci(number - 1) + fibonacci(number - 2));
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 15; i++) {
            System.out.println(fibonacci(i));
        }
    }
}
