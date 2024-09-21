package org.example.others;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelExample {
    public static void main(String[] args) {
        String excelFile = "output.xlsx";

        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOut = new FileOutputStream(excelFile)) {

            Sheet sheet = workbook.createSheet("Data");
            // Creating header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Name");
            headerRow.createCell(1).setCellValue("Age");
            headerRow.createCell(2).setCellValue("Country");
            // simulate data
            Object[][] data = {
                    {"Alice", 30, "USA"},
                    {"Bob", 25, "Canada"},
                    {"Charlie", 35, "UK"}
            };
            int rowNum = 1;
            for (Object[] rowData : data) {
                Row row = sheet.createRow(rowNum++);
                for (int i = 0; i < rowData.length; i++) {
                    row.createCell(i).setCellValue(rowData[i].toString());
                }
            }

            // Write to the file
            workbook.write(fileOut);
            System.out.println("Excel write successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}