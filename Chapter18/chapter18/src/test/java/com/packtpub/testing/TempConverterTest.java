package com.packtpub.testing;

import org.junit.jupiter.api.*;

public class TempConverterTest {

    @Test
    public void testFahrenheitWhenCold() {
        // -40 C == -40 F
        double degreesC = -40.0;

        double degreesF = TempConverter.convertToF(degreesC);

        Assertions.assertEquals(degreesC, degreesF);
    }

    @Test
    public void testFahrenheitWhenHot() {
        // 100 C == 212 F
        double degreesC = 100.0;

        double degreesF = TempConverter.convertToF(degreesC);

        Assertions.assertEquals(212.0, degreesF);
    }

    @BeforeAll
    public static void runBeforeAllTests() {
        System.out.println("Before all tests");
    }

    @AfterAll
    public static void runAfterAllTests() {
        System.out.println("After all tests");
    }

    @BeforeEach
    public void runBeforeEachTest() {
        System.out.println("Before each test");
    }

    @AfterEach
    public void runAfterEachTest() {
        System.out.println("After each test");
    }
}
