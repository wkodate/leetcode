package com.wkodate.leetcode.LC0747_LargestNumberAtLeastTwiceOfOthers;

public class Solution {

    public int dominantIndex(int[] nums) {
        int maxIdx = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                maxIdx = i;
                max = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == maxIdx) {
                continue;
            }
            if (max < 2 * nums[i]) {
                return -1;
            }
        }
        return maxIdx;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println(solution.dominantIndex(new int[]{1,2,3,4}));
    }

}
