package org.example.csv;

import java.io.FileWriter;
import java.io.IOException;

public class BasicWriteCSVDemo {
    public static void main(String[] args) {
        String csvFile = "output.csv";
        String[] header = {"Name", "Age", "Country"};
        String[][] data = {
                {"Alice", "30", "USA"},
                {"Bob", "25", "Canada"},
                {"Charlie", "35", "UK"}
        };
        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.append(String.join(",", header));
            writer.append("\n");
            // simulator the data, real data can be from network/MQ or database
            for (String[] row : data) {
                writer.append(String.join(",", row));
                writer.append("\n");
            }
            System.out.println("CSV file write successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
