package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTask implements Runnable {
    private int i;

    public MyTask(int i) {
        // demo for accept some params from external
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("Thread " + this.i + " is running");
    }
}

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new MyTask(1));
        executorService.execute(new MyTask(2));
        executorService.shutdown();
    }
}
