package demo.adFileops;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirectoryWalkExample {
    public static void main(String[] args) {
        Path startPath = Paths.get("directory_to_walk");

        try (Stream<Path> paths = Files.walk(startPath)) {
            paths.filter(Files::isRegularFile)
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
