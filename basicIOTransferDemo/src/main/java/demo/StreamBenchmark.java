package demo;

import java.io.*;

public class StreamBenchmark {
    private static final int BUFFER_SIZE = 8192;

    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String targetFile = "target.txt";

        // 使用缓冲流进行文件复制
        long startTime = System.nanoTime();
        copyFileUsingBufferedStream(sourceFile, targetFile);
        long bufferedTime = System.nanoTime() - startTime;

        // 使用非缓冲流进行文件复制
        startTime = System.nanoTime();
        copyFileUsingStream(sourceFile, targetFile);
        long nonBufferedTime = System.nanoTime() - startTime;

        System.out.println("Buffered Stream time: " + bufferedTime + " ns");
        System.out.println("Non-Buffered Stream time: " + nonBufferedTime + " ns");
    }

    private static void copyFileUsingBufferedStream(String source, String target) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFileUsingStream(String source, String target) {
        try (InputStream is = new FileInputStream(source);
             OutputStream os = new FileOutputStream(target)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
