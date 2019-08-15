package com.packtpub.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class DailyGoalTest {
    public static final int DAILY_GOAL = 10000;

    @ParameterizedTest
    @ValueSource(ints = { 10000, 11000 })
    public void testMetStepGoal(int steps) {
        DailyGoal dailyGoal = new DailyGoal(DAILY_GOAL);

        Assertions.assertTrue(dailyGoal.hasMetGoal(steps));
    }

    @ParameterizedTest
    @ValueSource(ints = { 10, 9999 })
    public void testNotMetStepGoal(int steps) {
        DailyGoal dailyGoal = new DailyGoal(DAILY_GOAL);

        Assertions.assertFalse(dailyGoal.hasMetGoal(steps));
    }

    @ParameterizedTest
    @CsvSource({
        "10,     false",
        "9999,   false",
        "10000,  true",
        "20000,  true"
    })
    public void testHasMetStepGoal(int steps, boolean expected) {
        DailyGoal dailyGoal = new DailyGoal(DAILY_GOAL);

        // Using a lambda will lazily evaluate the expression
        Assertions.assertTrue(
                dailyGoal.hasMetGoal(steps) == expected,
                () -> "With " + steps +
                      " steps, hasMetGoal() should return " +
                        expected);
    }
}
