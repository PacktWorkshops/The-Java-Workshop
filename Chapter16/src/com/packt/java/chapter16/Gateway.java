package com.packt.java.chapter16;

public class Gateway implements Sensor {

    private int batteryHealth;

    private boolean triggered;

    public Gateway(int batteryHealth, boolean isTriggered) {
        this.batteryHealth = batteryHealth;
        this.triggered = isTriggered;
    }

    @Override
    public int batteryHealth() {
        return batteryHealth;
    }

    @Override
    public void batteryHealth(int health) {
        batteryHealth = health;
    }

    @Override
    public boolean triggered() {
        return triggered;
    }

    @Override
    public void triggered(boolean state) {
        triggered = state;
    }

}
