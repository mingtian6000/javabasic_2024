package demo.vendors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVExample {
    public static void generateCSV() {
        // ideally data should get from outside
        String[] headers = {"Name", "Age", "City"};
        String[][] data = {
                {"John Doe", "25", "New York"},
                {"Jane Smith", "30", "London"},
                {"Tom Johnson", "35", "Paris"}
        };

        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Sheet1");

            // write header
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            // write data
            for (int i = 0; i < data.length; i++) {
                Row dataRow = sheet.createRow(i + 1);
                for (int j = 0; j < data[i].length; j++) {
                    Cell cell = dataRow.createCell(j);
                    cell.setCellValue(data[i][j]);
                }
            }

            try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("data.csv"), StandardCharsets.UTF_8)) {
                CSVPrinter csvPrinter = new CSVPrinter(osw, CSVFormat.DEFAULT);
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        csvPrinter.print(cell.getStringCellValue());
                    }
                    csvPrinter.println();
                }
                csvPrinter.flush();
                csvPrinter.close();
            }
            System.out.println("CSV file generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readCSV() {
        try (Reader reader = Files.newBufferedReader(Paths.get("data.csv"), StandardCharsets.UTF_8)) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            for (CSVRecord csvRecord : csvParser) {
                for (String cell : csvRecord) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        generateCSV();
        readCSV();
    }
}
