package com.packtpub.activity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Delivery {
    public static final double EARTH_RADIUS = 6367;
    public static final double MAX_DISTANCE = 5.0;

    private Location customer;
    private Location restaurant;
    private double distance;
    private boolean withinMaximum = false;


    public void init(double customerLat, double customerLong,
                     double restaurantLat, double restaurantLong) {
        customer = new Location(customerLat, customerLong);
        restaurant = new Location(restaurantLat, restaurantLong);
        distance = calculateDistance();

        withinMaximum = false;
        if (distance <= MAX_DISTANCE) {
            withinMaximum = true;
        }
    }


    public double calculateDistance() {
        return haversine(customer.getLatitude(),
                customer.getLongitude(),
                restaurant.getLatitude(),
                restaurant.getLongitude());
    }


    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Delivery \n");
        builder.append("  Customer: ");
        builder.append((customer.toString()));
        builder.append(("\n  Restaurant: "));
        builder.append((restaurant.toString()));

        builder.append("\n  Distance: ");
        builder.append(distance);
        builder.append(" km");

        if (withinMaximum) {
            builder.append("\n  Is within maximum distance of ");
        } else {
            builder.append("\n  Is not within maximum distance of ");
        }

        builder.append(MAX_DISTANCE);

        return builder.toString();
    }


    // Generated getters and setters.
    public Location getCustomer() {
        return customer;
    }

    public void setCustomer(Location customer) {
        this.customer = customer;
    }

    public Location getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Location restaurant) {
        this.restaurant = restaurant;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public boolean isWithinMaximum() {
        return withinMaximum;
    }

    public void setWithinMaximum(boolean withinMaximum) {
        this.withinMaximum = withinMaximum;
    }

    // See http://www.faqs.org/faqs/geography/infosystems-faq/ Q5.1
    public static double haversine(double latitude1, double longitude1,
                                   double latitude2, double longitude2) {

        double deltaLat  = Math.toRadians(latitude2 - latitude1);
        double deltaLong = Math.toRadians(longitude2 - longitude1);

        double lat1Radians = Math.toRadians(latitude1);
        double lat2Radians = Math.toRadians(latitude2);

        double a = Math.pow(Math.sin(deltaLat / 2),2) +
                Math.cos(lat1Radians) *
                Math.cos(lat2Radians) *
                Math.pow(Math.sin(deltaLong / 2),2);

        double greatCircleDistance = 2 * Math.asin(Math.sqrt(a));
        return EARTH_RADIUS * greatCircleDistance;
    }



    public static void main(String[] args) {

        // State Capitol, Minnesota, USA
        Delivery delivery = new Delivery();
        delivery.init(
                44.955276, -93.102228,
                44.943946, -93.104265
        );
        System.out.println(delivery);

        // Victoria and Albert Museum, London, UK
        delivery.init(
                51.497559, -0.172427,
                51.485540, -0.162114

        );
        System.out.println(delivery);


        // Natural History Museum, Stockholm, Sweden
        delivery.init(
                59.369072, 18.053856,
                59.308545, 18.066242

        );
        System.out.println(delivery);

        // Convert to JSON.
        String json = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            json = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(delivery);

            System.out.println("As JSON:\n" + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // Convert from JSON to object.
        try {
            delivery = objectMapper.readValue(json, Delivery.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("From JSON: " + delivery);
    }
}
