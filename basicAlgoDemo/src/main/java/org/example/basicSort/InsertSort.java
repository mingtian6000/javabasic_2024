package org.example.basicSort;

public class InsertSort {
    public void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1};
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
