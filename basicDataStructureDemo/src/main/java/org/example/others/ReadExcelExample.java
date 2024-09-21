package org.example.others;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;

public class ReadExcelExample {
    public static void main(String[] args) throws IOException {
        //String excelFile = "output.xlsx";
        InputStream xlsStream = ReadExcelExample.class.getClassLoader().getResourceAsStream("output.xlsx");
        Workbook workbook = new XSSFWorkbook(xlsStream);


        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t");
                        break;
                    default:
                        break;
                }
            }
            System.out.println();
        }

    }
}
