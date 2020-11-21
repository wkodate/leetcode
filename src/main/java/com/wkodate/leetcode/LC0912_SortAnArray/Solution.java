package com.wkodate.leetcode.LC0912_SortAnArray;

import static java.lang.System.out;

import java.util.Arrays;

public class Solution {

    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int mink = i;
            int minv = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < minv) {
                    mink = j;
                    minv = nums[j];
                }
            }
            int tmp = nums[i];
            nums[i] = minv;
            nums[mink] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2,3,5]
        out.println(Arrays.toString(s.sortArray(new int[] { 5, 2, 3, 1 })));
        // [0,0,1,1,2,5]
        out.println(Arrays.toString(s.sortArray(new int[] { 5, 1, 1, 2, 0, 0 })));
    }

}
