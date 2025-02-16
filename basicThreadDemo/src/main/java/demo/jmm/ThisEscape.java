package demo.jmm;

import java.io.IOException;

public class ThisEscape {
    private int num=0;
    public ThisEscape() {
        // this -》 构造函数还没构造完就开始访问了。。 极端概率有可能为0.。
        // effective java:不要再构造函数里启动线程！！
        new Thread(()-> System.out.println(this.num)).start();
    }

    public static void main(String[] args) throws IOException {
        new ThisEscape();
        System.in.read();
    }
}
