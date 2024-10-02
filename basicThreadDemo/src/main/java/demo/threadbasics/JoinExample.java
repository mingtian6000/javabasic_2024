package demo.threadbasics;

class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("sub Thread is running.");
        try {
            Thread.sleep(2000); // Simulating some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sub Thread has finished.");
    }
}

public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        MyThread1 thread = new MyThread1();
        thread.start();
        thread.join(); // 谁调用join谁就先进来执行
        System.out.println("Main thread continues after 'sub thread' has finished.");
    }
}
