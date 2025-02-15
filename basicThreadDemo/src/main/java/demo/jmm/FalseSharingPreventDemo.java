package demo.jmm;


public class FalseSharingPreventDemo {
    private static final int NUM_THREADS = 4;
    private static final int NUM_ITERATIONS = 100000;

    private static class SharedData {
        public long x;
        public long p1, p2, p3, p4, p5, p6, p7; // Padding to prevent false sharing

        public long y;
        public long q1, q2, q3, q4, q5, q6, q7; // Padding to prevent false sharing
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
        //shared data 245647 : 269292
        //Execution time: 10ms
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("shared data " + sharedData.x +" : " + sharedData.y);
        System.out.println("Execution time: " + executionTime + "ms");
    }
}