package demo;

import java.util.concurrent.FutureTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
//method1
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread.run() just simple demo");
    }
}

//method2
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable.run() just simple demo");
    }
}

//3rd
class MyCallable implements java.util.concurrent.Callable<String> {
    @Override
    public String call() throws Exception {
        return "MyCallable.call() just simple demo";
    }
}

//4th: thread pool, executor framework--see another class

public class ThreadExample {
    public static void main(String[] args) {
        Thread myThread = new MyThread();
        Thread myRunnable = new Thread(new MyRunnable());
        Callable<String> callable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread myCallable = new Thread(futureTask);
        myCallable.start();
        myThread.start();
        myRunnable.start();
        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
