package com.packtpub.recursion;

public class RunForever {
    public int add(int num) {

        return add(num + 1);
    }

    public static void main(String[] args) {
        RunForever runForever = new RunForever();

        System.out.println(runForever.add(1));
    }
}
