package demo;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {
    public static void readDemo(){
        try {
            RandomAccessFile file = new RandomAccessFile("data.txt", "rw");
            file.writeBytes("Hello, World!");

            file.seek(7);

            byte[] buffer = new byte[6];
            file.read(buffer);
            System.out.println(new String(buffer));
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDemo(){
        try {
            RandomAccessFile file = new RandomAccessFile("data.txt", "rw");
            file.writeBytes("Hello, World!");

            file.seek(7);

            //如果后续文件太大，也可以创建一个临时文件来保存
            byte[] temp = new byte[(int) file.length() - 7];
            file.read(temp);
            //一旦调用read，文件指针就会移动
            file.seek(7);
            file.writeBytes("Inserted Data!");
            file.write(temp);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readDemo();
        writeDemo();
    }
}
