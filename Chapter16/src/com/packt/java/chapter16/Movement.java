package com.packt.java.chapter16;

public class Movement implements Sensor {

    private int batteryHealth;

    private boolean isTriggered;

    private int ambientLight;

    public Movement(int batteryHealth, boolean isTriggered, int ambientLight) {
        this.batteryHealth = batteryHealth;
        this.isTriggered = isTriggered;
        this.ambientLight = ambientLight;
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
        return isTriggered;
    }

    @Override
    public void triggered(boolean state) {

    }

    public int ambientLight() {
        return ambientLight;
    }

}
