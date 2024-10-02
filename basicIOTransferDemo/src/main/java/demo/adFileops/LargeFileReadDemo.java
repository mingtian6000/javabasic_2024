package demo.adFileops;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LargeFileReadDemo {
    /* just simple demo for if huge files, what kind of ways we can use */
    public static void main(String[] args) {

    }

    private static void bufferedReaderDemo(String filePath){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath), 8192)) { // Increased buffer size
            String line;
            while ((line = br.readLine()) != null) {
                // Process the line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //memory-mapped files allows you to map a file directly into memory
    private static void MemoryMappedFileDemo(String filePath){
        try (RandomAccessFile file = new RandomAccessFile(filePath, "r");
             FileChannel channel = file.getChannel()) {
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());

            while (buffer.hasRemaining()) {
                // Read characters from the buffer
                char c = (char) buffer.get();
                // Process character
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //If the file can be split into sections that can be processed independently,
    // consider reading and processing the file in parallel using Java's ForkJoinPool or ExecutorService.
/*    private static void ParallelFileReadingDemo(String filePath){
        ExecutorService executor = Executors.newFixedThreadPool(4); //adjust numbers

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String finalLine = line;
                executor.submit(() -> processLine(finalLine)); // Process each line in a separate thread
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }*/

    private static void processLine(String line) {
        System.out.println(line);
        //or other processing logic
    }
}
