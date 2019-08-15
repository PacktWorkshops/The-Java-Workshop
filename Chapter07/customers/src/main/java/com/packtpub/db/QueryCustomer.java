package com.packtpub.db;

import java.sql.*;

public class QueryCustomer {
    public static void main(String[] args) {

        String sql = "SELECT * from customer order by username";

        Statement statement;

        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

            statement = conn.createStatement();

            ResultSet results = statement.executeQuery(sql);

            while (results.next()) {
                Customer customer = new Customer(
                        results.getLong("CUSTOMER_ID"),
                        results.getString("USERNAME"),
                        results.getString("FIRST_NAME"),
                        results.getString("LAST_NAME")
                );

                System.out.println(customer.toString());
            }

            if (results != null) {
                results.close();
            }

            if (statement != null) {
                statement.close();
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
