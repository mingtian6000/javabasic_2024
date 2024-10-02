package demo.fileops;

import java.io.*;

public class StreamExample {

    public static final int BUFFER_SIZE=4096;
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        outputStream.close();
        return outputStream.toByteArray();
    }

    public static void main(String[] args) {
        // byteStream
        try {
            OutputStream outputStream = new FileOutputStream("byte_stream.txt");
            outputStream.write("Hello, World!".getBytes());
            outputStream.close();
            // already know the boundary
            InputStream inputStream = new FileInputStream("byte_stream.txt");
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // charStream
        try {
            Writer writer = new FileWriter("char_stream.txt");
            writer.write("Hello, World!");
            writer.close();

            Reader reader = new FileReader("char_stream.txt");
            int data;
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
