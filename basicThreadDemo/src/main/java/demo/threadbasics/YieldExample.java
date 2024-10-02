package demo.threadbasics;


class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread is running: " + i);
            //但这个behanbior是不确定的，多run几次就知道了
            Thread.yield(); // Yielding the processor to other threads
        }
    }
}

public class YieldExample {
    public static void main(String[] args) {
        MyThread2 thread = new MyThread2();
        thread.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Main thread is running: " + i);
        }
    }
}
