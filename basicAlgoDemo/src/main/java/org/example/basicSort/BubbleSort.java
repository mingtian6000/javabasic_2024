package org.example.basicSort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] testArr =  new int[]{1,2,5,3,7,8,6,4};
        bubbleSort(testArr);
        for(int i=0; i< testArr.length; i++){
            System.out.print(testArr[i]+" ");
        }

    }

    private static void bubbleSort(int[] arr){
        int temp;
        int swapTimes = 0;
        boolean swapped = false;
        // for asc order
        for(int i=0; i< arr.length; i++){
            for(int j=i+1; j< arr.length; j++){
                //swap condition
                if(arr[i]>arr[j]){
                    swapped = true;
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    swapTimes++;
                }
            }
            if(!swapped){break;} // early exit, already sorted!!
        }
        System.out.println("total swapTimes:"+swapTimes);
    }
}
