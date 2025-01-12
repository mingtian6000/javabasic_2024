package demo.queue;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue q1 = new ArrayBlockingQueue(5);

        // one thread dedicate for adding elements to the queue
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    q1.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date() + "Added " + i + " to the queue");
            }
            System.out.println(new Date() + " ArrayBlockingQueue For End.");
        }).start();

        // another one dedicate for taking elements from the queue
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                    if (!q1.isEmpty()) {
                        System.out.println(q1.take());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
