package demo.threadbasics;

class MyThread3 extends Thread {
    private volatile boolean isTerminated = false;

    public void terminate() {
        isTerminated = true;
    }

    @Override
    public void run() {
        while (!isTerminated) {
           System.out.println(getName() + " is running");
        }
    }
}

class MyThread4 extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(getName() + " is running");
        }
    }
}

public class ThreadTerminationExample {
    public static void main(String[] args) throws InterruptedException {
        MyThread3 thread = new MyThread3();
        thread.start();
        MyThread4 anotherThread = new MyThread4();
        anotherThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.terminate();
        Thread.sleep(100);
        anotherThread.interrupt();
    }

    
}
