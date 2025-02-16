package demo.jmm;

import java.util.HashSet;

public class Singleton2 {
    private static volatile Singleton2 INSTANCE;
    private Singleton2(){}

    public static /*synchronized*/ Singleton2 getInstance(){
        if(INSTANCE==null){ // 要有，不然每个线程都来锁竞争
            synchronized (Singleton2.class) {
                if(INSTANCE==null) { //DCL double check lock，不然只有一个synchronzie起不到作用
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    INSTANCE = new Singleton2();
                }
            }
        }
        return INSTANCE;
    }
    public void f(){
        System.out.println("just test fucntion, print anything");
    }

    public static void main(String[] args) {

    }
}
