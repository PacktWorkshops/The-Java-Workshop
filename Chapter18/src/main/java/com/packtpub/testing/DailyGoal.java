package com.packtpub.testing;

public class DailyGoal {
    int dailyGoal = 10000;

    public DailyGoal(int dailyGoal) {

        this.dailyGoal = dailyGoal;
    }

    public boolean hasMetGoal(int steps) {
        if (steps >= dailyGoal) {
            return true;
        }

        return false;
    }
}
