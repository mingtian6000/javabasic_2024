package demo.report;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class GenerateReportExample {
    public static void main(String[] args) {
        try {
            // prepare data or fetch data
            List<Person> personList = new ArrayList<>();
            personList.add(new Person("John Doe", 25));
            personList.add(new Person("Jane Smith", 30));
            personList.add(new Person("Tom Johnson", 35));

            // set params
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("ReportTitle", "Person Report");

            //File file = ResourceUtils.getFile("classpath:report_template.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport("basicIOStreamDemo\\src\\main\\resources\\report_template.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JRBeanCollectionDataSource(personList));

            JasperExportManager.exportReportToPdfFile(jasperPrint, "report.pdf");

            System.out.println("Report generated successfully.");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
