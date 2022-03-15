package com.wkodate.leetcode.LC0746_MinCostClimbingStairs;

public class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int f1 = 0;
        int f2 = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 15
        System.out.println(s.minCostClimbingStairs(new int[]{10, 15, 20}));
        // 6
        System.out.println(s.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

}
