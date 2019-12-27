package com.wkodate.leetcode.LC0453_MinimumMovesToEqualArrayElements;

import java.util.Arrays;

public class Solution {

    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum - nums[0] * nums.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.minMoves(new int[]{1, 2, 3}));
        System.out.println(s.minMoves(new int[]{1, 2147483647}));
    }

}
