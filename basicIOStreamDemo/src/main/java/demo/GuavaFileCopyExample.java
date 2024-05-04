package demo;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public class GuavaFileCopyExample {
    public static void main(String[] args) {
        try {
            File sourceFile = new File("source.txt");
            File targetFile = new File("target.txt");

            Files.copy(sourceFile, targetFile);

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
