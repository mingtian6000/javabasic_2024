package org.example.basicSort;

public class QuickSort {
    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = left; //选取第一个元素，也可以选中间的，随机的等
        int index = pivot + 1; //index指示小堆末端的位置
        for (int i = index; i <= right; i++) { //i 是个探针，pivot在第一位，往后走的过程把乱堆的元素分成大小堆
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++; //小堆元素增长，要加1
            }
        }
        swap(arr, pivot, index - 1);//loop完要交换基准和小堆最后一个元素
        System.out.println("return : " + (index - 1) + " left: " + left + " right: " + right);
        return index - 1;// 以基准为边界，分为大小堆

    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 5, 2, 3, 1};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
