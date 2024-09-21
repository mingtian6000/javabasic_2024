package org.example.others;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class BasicPdfDemo {
    public static void main(String[] args) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.newLineAtOffset(100, 700);
                // here use some data to simulate your real data stream
                contentStream.showText("Hello, PDF!");
                contentStream.endText();
            }

            document.save("output.pdf");
            System.out.println("PDF write ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
