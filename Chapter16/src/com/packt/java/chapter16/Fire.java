package com.packt.java.chapter16;

public class Fire implements Sensor {

    private int batteryHealth;

    private boolean triggered;

    private int temperature;

    public Fire(int batteryHealth, boolean isTriggered, int temperature) {
        this.batteryHealth = batteryHealth;
        this.triggered = isTriggered;
        this.temperature = temperature;
    }

    @Override
    public int batteryHealth() {
        return batteryHealth;
    }

    @Override
    public void batteryHealth(int health) {

    }

    @Override
    public boolean triggered() {
        return triggered;
    }

    @Override
    public void triggered(boolean state) {

    }

    public int temperature() {
        return temperature;
    }

}
