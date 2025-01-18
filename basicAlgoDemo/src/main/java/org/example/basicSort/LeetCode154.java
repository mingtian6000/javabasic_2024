package org.example.basicSort;

import java.util.Arrays;

public class LeetCode154 {
    //二分查找的变体，查找旋转点
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left <right) {
            int mid = left + (right - left) /2;
            if (nums[mid] > nums[right]) {
                left = mid+1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}
