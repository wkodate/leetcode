package com.wkodate.leetcode.LC0453_MinimumMovesToEqualArrayElements;

public class Solution {

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }
        return sum - min * nums.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.minMoves(new int[]{1, 2, 3}));
        System.out.println(s.minMoves(new int[]{1, 2147483647}));
    }

}
