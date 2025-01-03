package newfeatures;

import java.time.Duration;
import java.util.concurrent.Executors;
public class VirtualThread {
    public static void main(String[] args) throws InterruptedException {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10000; i++) {
                int finalI = i;
                executor.submit(() -> {
                    System.out.println("Task " + finalI + " is running on " + Thread.currentThread());
                    try {
                        Thread.sleep(Duration.ofSeconds(1));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }
}
