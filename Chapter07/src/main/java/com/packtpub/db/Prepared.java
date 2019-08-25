package com.packtpub.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Prepared {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement statement = null;

        String sql = "UPDATE email " +
            "SET EMAIL_ADDRESS = ? " +
            "WHERE customer_id = ? " +
            "AND email_type = ? ";


        try {
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            conn.setAutoCommit(false);

            statement = conn.prepareStatement(sql);
            statement.setString(1, "bob.marley@another_company.com");
            statement.setLong(2, 1L);
            statement.setString(3, "WORK");

            int rowsChanged = statement.executeUpdate();

            conn.commit();

            System.out.println("Number rows changed: " + rowsChanged);

        } catch (SQLException e) {
            e.printStackTrace();

            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException nested) {
                nested.printStackTrace();
            }

        } finally {
            try {
                conn.setAutoCommit(true);

                if (statement != null) {
                    statement.close();
                }

                conn.close();
            } catch (SQLException nested) {
                nested.printStackTrace();
            }
        }
    }
}
