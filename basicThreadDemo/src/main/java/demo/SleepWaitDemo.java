package demo;

public class SleepWaitDemo {
    public static void main(String[] args) {
        final Object lock = new Object();

        Thread sleepThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Sleep Thread started.");
                try {
                    Thread.sleep(3000); // Sleep for 3 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Sleep Thread finished.");
            }
        });

        Thread waitThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Wait Thread started.");
                try {
                    lock.wait(3000); // Wait for 3 seconds, timeout will wake up
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Wait Thread finished.");
            }
        });

        sleepThread.start();
        waitThread.start();
    }
}