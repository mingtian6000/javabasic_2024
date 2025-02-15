package demo.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class NoLock {
    private static volatile int count = 0;
    //Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        NoLock noLock = new NoLock();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    //noLock.lock.lock();
                    synchronized(NoLock.class) { //明显感觉慢很多
                        count++;
                    }
                    //noLock.lock.unlock();
                }
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count); //876596
        //加上volatile 呢？ 971606 依旧不能解决，因为volatile只能保证读 不能保证写
        //用lock
    }
}
