package demo.jmm;

public class FalseSharingDemo{
    private static final int NUM_THREADS = 4;
    private static final int NUM_ITERATIONS = 1_000_000;
    
    private static class SharedData {
        public volatile long x;
        public volatile long y;
    }

    private static class WorkerThread implements Runnable {
        private final SharedData sharedData;

        public WorkerThread(SharedData sharedData) {
            this.sharedData = sharedData;
        }

        public void run() {
            for (int i = 0; i < NUM_ITERATIONS; i++) {
                sharedData.x++;
                sharedData.y++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SharedData sharedData = new SharedData();

        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(new WorkerThread(sharedData));
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].start();
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].join();
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("shared data " + sharedData.x +" : " + sharedData.y);
        System.out.println("Execution time: " + executionTime + "ms");
    }
}