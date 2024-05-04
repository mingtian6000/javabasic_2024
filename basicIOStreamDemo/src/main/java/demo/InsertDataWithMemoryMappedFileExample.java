package demo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class InsertDataWithMemoryMappedFileExample {
    public static void main(String[] args) {
        String filename = "data.txt";
        int insertPosition = 7;
        String dataToInsert = "Inserted Data!";

        try {
            RandomAccessFile file = new RandomAccessFile(filename, "rw");
            FileChannel channel = file.getChannel();

            // 将文件的一部分映射到内存（读写模式）
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size());
            // insert data
            buffer.position(insertPosition);
            buffer.put(dataToInsert.getBytes());

            // no need to rewrite to original file?
            channel.close();
            file.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
