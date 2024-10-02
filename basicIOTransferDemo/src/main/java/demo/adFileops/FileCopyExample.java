package demo.adFileops;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCopyExample {
    public static void main(String[] args) {
        // all classes used under NIO
        Path sourcePath = Paths.get("source.txt");
        Path destinationPath = Paths.get("destination.txt");

        try {
            Files.copy(sourcePath, destinationPath);
            //Files.move();
            //Files.delete("abc.txt");
            //Files.readAttributes(filePath, BasicFileAttributes.class);
            //Files.write(filePath, content.getBytes(), StandardOpenOption.APPEND);
            //Files.lines(filePath).forEach(System.out::println); //read line by line
            System.out.println("File copied successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
