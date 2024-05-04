package demo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeapExample {
    public static void main(String[] args) {
        // 创建自定义比较器，反转元素的排序顺序
        Comparator<Integer> maxHeapComparator = Comparator.reverseOrder();

        // 使用自定义比较器创建大根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(maxHeapComparator);
        maxHeap.add(5);
        maxHeap.add(3);
        maxHeap.add(1);
        maxHeap.add(6);
        maxHeap.add(9);
        maxHeap.add(2);

        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }
}
