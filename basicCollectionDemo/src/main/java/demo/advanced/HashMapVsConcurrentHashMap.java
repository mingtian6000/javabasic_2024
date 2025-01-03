package demo.advanced;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class HashMapVsConcurrentHashMap {
    private static final int THREAD_COUNT = 1000;
    private static final int ITERATIONS = 1000;

    public static void main(String[] args) throws InterruptedException {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ExecutorService hashMapExecutor = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int index = i;
            hashMapExecutor.execute(() -> {
                for (int j = 0; j < ITERATIONS; j++) {
                    hashMap.put(index, hashMap.getOrDefault(index, 0) + 1);
                }
            });
        }

        hashMapExecutor.shutdown();
        hashMapExecutor.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES);
        System.out.println("HashMap size: " + hashMap.size());

        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        ExecutorService concurrentHashMapExecutor = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int index = i;
            concurrentHashMapExecutor.execute(() -> {
                for (int j = 0; j < ITERATIONS; j++) {
                    concurrentHashMap.put(index, concurrentHashMap.getOrDefault(index, 0) + 1);
                }
            });
        }

        concurrentHashMapExecutor.shutdown();
        concurrentHashMapExecutor.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES);
        System.out.println("ConcurrentHashMap size: " + concurrentHashMap.size());
    }
}
