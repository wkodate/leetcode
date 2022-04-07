package com.wkodate.leetcode.LC0674_LongestContinuousIncreasingSubsequence;

public class Solution {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
                maxCount = Math.max(maxCount, count);
                continue;
            }
            count = 0;
        }
        return maxCount + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        // 1
        System.out.println(s.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
        // 0
        System.out.println(s.findLengthOfLCIS(new int[]{}));
    }

}
