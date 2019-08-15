package com.packtpub.reflection;

public class LatLong {
    private String latitude;
    private String longitude;

    public String toString() {
        return "latitude: " + latitude + ", longitude: " + longitude;
    }

    // Generated
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}
