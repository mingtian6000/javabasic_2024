package org.example.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BasicConnection {
    public static void main(String[] args) {
            String url = "jdbc:postgresql://localhost:5432/mydatabase";
            String user = "postgres";
            String password = "postgres";

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT version()")) {

                if (rs.next()) {
                    System.out.println("PostgreSQL version: " + rs.getString(1));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
