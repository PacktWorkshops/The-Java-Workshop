package com.packtpub.db;

import java.sql.*;

public class ShowProgress {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.err.println("Error: please enter the first and last name.");
            System.exit(-1);
        }

        // Get student first and last name as inputs.
        String firstName = args[0].toUpperCase();
        String lastName = args[1].toUpperCase();

        // Query all chapters completed for the student.
        String sql = "SELECT chapter.chapter_id, chapter_name, completed " +
                "FROM student, chapter, student_progress " +
                "WHERE first_name = ? " +
                "AND last_name = ? " +
                "AND student.student_id = student_progress.student_id " +
                "AND chapter.chapter_id = student_progress.chapter_id " +
                " order by chapter_id";

        PreparedStatement statement = null;

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

            statement = conn.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);

            ResultSet results = statement.executeQuery();

            System.out.println(firstName + " " + lastName);

            while (results.next()) {
                Long chapterId = results.getLong("CHAPTER_ID");
                String chap = chapterId.toString();
                if (chap.length() < 2) {
                    chap = " " + chap;
                }

                StringBuilder builder = new StringBuilder();
                builder.append( results.getDate("COMPLETED"));
                builder.append(" ");
                builder.append(chap);
                builder.append(" ");
                builder.append( results.getString("CHAPTER_NAME" ) );

                System.out.println( builder.toString() );
            }

            if (results != null) {
                results.close();
            }

            if (statement != null) {
                statement.close();
            }

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
}
