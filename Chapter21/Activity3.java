package com.packt.java.chapter21;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class Activity3 {

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
        System.runFinalization();
        System.out.println("Test results: " + testResults.size());
    }

    private static class TestResult {
        WeakReference<Student> student;

        TestResult(Student student) {
            this.student = new WeakReference<>(student);
        }
    }
}

