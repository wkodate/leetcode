package com.wkodate.leetcode.LC0031_NextPermutation;

import java.util.Arrays;

public class Solution {

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1,3,2
        s.nextPermutation(new int[]{1, 2, 3});
        // 1,2,3
        s.nextPermutation(new int[]{3, 2, 1});
        // 1,5,1
        s.nextPermutation(new int[]{1, 1, 5});
    }

}
