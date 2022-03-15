package com.wkodate.leetcode.LC0189_RotateArray;

public class Solution {

    public void rotate(int[] nums, int k) {
        // Using Extra Array
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[(k + i) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

}
