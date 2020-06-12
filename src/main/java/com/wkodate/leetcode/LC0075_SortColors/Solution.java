package com.wkodate.leetcode.LC0075_SortColors;

import java.util.Arrays;

public class Solution {

    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int idx = i;
            int min = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    idx = j;
                    min = nums[j];
                }
            }
            int tmp = nums[idx];
            nums[idx] = nums[i];
            nums[i] = tmp;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,0,1,1,2,2]
        s.sortColors(new int[] { 2, 0, 2, 1, 1, 0 });
    }

}
