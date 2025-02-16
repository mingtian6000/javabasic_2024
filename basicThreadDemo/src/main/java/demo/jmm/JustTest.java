package demo.jmm;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.locks.ReentrantLock;

public class JustTest {
    static class T{
        int m=8;
        boolean b=false;
        String s="asdfakldkalfas";
    }
    public static void main(String[] args) {
        //对象的创建过程？？
        JustTest o = new JustTest();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o){
            //thin lock 可能模拟一些超时会变成重量级锁
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println("##############################################");
        ReentrantLock lock = new ReentrantLock();
        lock.lock(); // lock
        System.out.println(ClassLayout.parseInstance(o).toPrintable()); //still non-biasable
        lock.unlock();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
