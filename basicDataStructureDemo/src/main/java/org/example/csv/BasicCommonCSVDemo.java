package org.example.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BasicCommonCSVDemo {
    public static void main(String[] args) throws IOException {
        // Writing to CSV???
        try (FileWriter writer = new FileWriter("output.csv", StandardCharsets.UTF_8);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Name", "Age", "Country"))) {
            // Write data
            csvPrinter.printRecord("Alice", 30, "USA");
            csvPrinter.printRecord("Bob", 25, "Canada");
            csvPrinter.printRecord("Charlie", 35, "UK");
        }


        // Reading from CSV,
        try (FileReader reader = new FileReader("output.csv", StandardCharsets.UTF_8);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            for (CSVRecord record : csvParser) {
                String name = record.get("Name");
                String age = record.get("Age");
                String country = record.get("Country");
                System.out.println(name + ", " + age + ", " + country);
            }
        }
    }
}
