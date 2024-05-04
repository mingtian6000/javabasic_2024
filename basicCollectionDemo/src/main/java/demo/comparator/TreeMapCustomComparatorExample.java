package demo.comparator;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapCustomComparatorExample {
    public static void main(String[] args) {
        Comparator<String> customComparator1 = new CustomComparatorByLength();
        Comparator<String> customComparator2 = new CustomComparatorByAlpha();
        TreeMap<String, Integer> treeMap = new TreeMap<>(customComparator1);

        treeMap.put("apple", 3);
        treeMap.put("banana", 2);
        treeMap.put("cherry", 5); // by lenth because banana and cherry have same length..

        for (String key : treeMap.keySet()) {
            System.out.println(key + ": " + treeMap.get(key));
        }
    }

    // external comparators
    static class CustomComparatorByLength implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            // 按照字符串长度进行比较
            return Integer.compare(str1.length(), str2.length());
        }
    }

    static class CustomComparatorByAlpha implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            return CharSequence.compare(str1, str2);
        }
    }
}
