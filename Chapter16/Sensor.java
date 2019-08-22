package com.packt.java.chapter16;

public abstract interface Sensor {

    int batteryHealth();

    void batteryHealth(int health);

    boolean triggered();

    void triggered(boolean state);

}
