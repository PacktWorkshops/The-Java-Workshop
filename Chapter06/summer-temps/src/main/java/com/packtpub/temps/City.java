package com.packtpub.temps;

public class City {
    private String name;
    private String country;
    double summertimeHigh;      // In degrees C

    public City(String name, String country, double summertimeHigh) {
        this.name = name;
        this.country = country;
        this.summertimeHigh = summertimeHigh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getSummertimeHigh() {
        return summertimeHigh;
    }

    public void setSummertimeHigh(double summertimeHigh) {
        this.summertimeHigh = summertimeHigh;
    }

    public String format(boolean fahrenheit) {
        String degrees = summertimeHigh + " C";

        if (fahrenheit) {
            degrees = TempConverter.convertToF(summertimeHigh) + " F";
        }
        return name + ", " + country + " " + degrees;
    }
}
