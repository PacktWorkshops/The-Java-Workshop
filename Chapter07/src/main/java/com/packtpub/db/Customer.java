package com.packtpub.db;

public class Customer {
    Long customerId;
    String username;
    String firstName;
    String lastName;

    public Customer(Long customerId, String username, String firstName, String lastName) {
        this.customerId = customerId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
