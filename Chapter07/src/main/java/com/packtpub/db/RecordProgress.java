package com.packtpub.db;

import java.sql.*;

public class RecordProgress {
    public static void main(String[] args) {

        // Get input
        if (args.length < 3) {
            System.err.println("Error: please enter first last chapter.");
            System.exit(-1);
        }

        // Get student first and last name and chapter number.
        String firstName = args[0].toUpperCase();
        String lastName = args[1].toUpperCase();

        long chapterId = Long.parseLong(args[2]);;


        // Store a student_progress record
        RecordProgress progress = new RecordProgress();

        progress.storeStudentProgress(firstName, lastName, chapterId);

    }

    public void storeStudentProgress(String firstName,
                                     String lastName, long chapterId) {

        Connection conn = null;
        PreparedStatement statement = null;

        String insertProgress = "INSERT INTO student_progress " +
                "(STUDENT_ID, CHAPTER_ID, COMPLETED)" +
                "VALUES (?, ?, ?);";


        try {
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

            // The chapter ID is the same as the chapter number.

            // Get the student ID by looking up from the student's name.
            Long studentId = getStudentId(conn, firstName, lastName);

            statement = conn.prepareStatement(insertProgress);
            statement.setLong(1, studentId);
            statement.setLong(2, chapterId);

            // Completed now.
            statement.setDate(3, new Date(System.currentTimeMillis()));

            int rowsChanged = statement.executeUpdate();

            System.out.println("Number rows added: " + rowsChanged);

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }

                conn.close();
            } catch (SQLException nested) {
                nested.printStackTrace();
            }
        }
    }

    public Long getStudentId(Connection conn, String firstName,
                             String lastName) throws SQLException {
        Long studentId = 1L;

        String findStudent = "SELECT student_id from student" +
                " WHERE first_name = ? " +
                " AND last_name = ? ";

        PreparedStatement statement = conn.prepareStatement(findStudent);
        statement.setString(1, firstName);
        statement.setString(2, lastName);

        ResultSet results = statement.executeQuery();

        // We expect only one row returned.
        while (results.next()) {
            studentId = results.getLong(1);
        }

        return studentId;
    }
}
