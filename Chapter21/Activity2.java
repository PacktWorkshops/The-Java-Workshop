package com.packt.java.chapter21;

import java.util.WeakHashMap;

public class Activity2 {

    public static void main(String[] args) {
        Student harry = new Student("Harry");
        TestResult harryResult = new TestResult(harry);
        Student jenny = new Student("Jenny");
        TestResult jennyResult = new TestResult(jenny);

        WeakHashMap<Student, Integer> testResults = new WeakHashMap<>();
        testResults.put(harry, 23);
        testResults.put(jenny, 25);

        System.out.println("Test results: " + testResults.size());

        harry = null;
        System.gc();
        System.out.println("Test results: " + testResults.size());
    }

    private static class TestResult {
        Student student;

        TestResult(Student student) {
            this.student = student;
        }
    }
}

