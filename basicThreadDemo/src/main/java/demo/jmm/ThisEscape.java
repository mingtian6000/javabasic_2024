package demo.jmm;

import java.io.IOException;

public class ThisEscape {
    private int num=0;
    public ThisEscape() {
        new Thread(()-> System.out.println(this.num)).start();
    }

    public static void main(String[] args) throws IOException {
        new ThisEscape();
        System.in.read();
    }
}
