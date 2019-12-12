package com.wkodate.leetcode.LC0088_MergeSortedArray;

import java.util.Arrays;

public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m - 1;
        int idx2 = n - 1;
        int i = m + n - 1;
        while (idx1 >= 0 && idx2 >= 0) {
            if (nums1[idx1] < nums2[idx2]) {
                nums1[i--] = nums2[idx2--];
            } else {
                nums1[i--] = nums1[idx1--];
            }
        }
        while (idx2 >= 0) {
            nums1[i--] = nums2[idx2--];
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // [1,2,2,3,5,6]
        solution.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        // [1]
        solution.merge(new int[]{0}, 0, new int[]{1}, 1);
        // [1,2,3,4,5,6]
        solution.merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
        // [1,2,3,4,5]
        solution.merge(new int[]{0, 0, 0, 0, 0}, 0, new int[]{1, 2, 3, 4, 5}, 5);
    }

}
