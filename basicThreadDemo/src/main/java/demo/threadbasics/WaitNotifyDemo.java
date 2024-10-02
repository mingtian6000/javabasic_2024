package demo.threadbasics;

public class WaitNotifyDemo {
    // please note wait/notify all object  method, there must be object for locking!!
    private static final Object lock = new Object();
    public static void main(String[] args) {
        Thread thread1 = new Thread(new FirstThread());
        Thread thread2 = new Thread(new SecondThread());

        thread1.start();
        thread2.start();
    }

    private static class FirstThread implements Runnable {
        public void run() {
            synchronized (lock) {
                try {
                    System.out.println("First Thread is waiting...");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("First Thread is notified and resumed.");
                System.out.println("Performing some task...");
            }
        }
    }

    private static class SecondThread implements Runnable {
        public void run() {
            synchronized (lock) {
                System.out.println("Second Thread is performing some task...");
                try {
                    Thread.sleep(2000); // Simulating some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Second Thread is notifying First Thread.");
                lock.notify();
            }
        }
    }
}
