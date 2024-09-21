package org.example.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BasicOpenCSVDemo {
    public static void main(String[] args) throws IOException, CsvValidationException {
        // Writing to CSV
        try (CSVWriter writer = new CSVWriter(new FileWriter("output.csv"))) {
            String[] header = {"Name", "Age", "Country"};
            writer.writeNext(header);
            writer.writeNext(new String[]{"Alice", "30", "USA"});
            writer.writeNext(new String[]{"Bob", "25", "Canada"});
        }

        // Reading from CSV
        try (CSVReader reader = new CSVReader(new FileReader("output.csv"))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                System.out.println(nextLine[0] + ", " + nextLine[1] + ", " + nextLine[2]);
            }
        }
    }
}
