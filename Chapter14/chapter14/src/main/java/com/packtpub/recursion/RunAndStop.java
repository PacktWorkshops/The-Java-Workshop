package com.packtpub.recursion;

public class RunAndStop {

    public int add(int num) {

        if (num < 100) {
            return add(num + 1);
        }

        return num;
    }

    public static void main(String[] args) {
        RunAndStop runAndStop = new RunAndStop();

        System.out.println( runAndStop.add(1) );
    }
}
