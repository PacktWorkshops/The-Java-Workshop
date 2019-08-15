package com.packtpub.activity;

public class Location {
    private double latitude;
    private double longitude;

    public Location() {
        // Needed for conversion from JSON.
    }

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String toString() {
        return latitude + ", " + longitude;
    }
}
