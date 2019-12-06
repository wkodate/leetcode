package com.wkodate.leetcode.LC0485_MaxConsecutiveOnes;

public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                length++;
            } else {
                max = Math.max(max, length);
                length = 0;
            }
        }
        return Math.max(max, length);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

}
