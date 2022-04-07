package com.wkodate.leetcode.LC0070_ClimbingStairs;

public class Solution2 {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 2
        System.out.println(s.climbStairs(2));
        // 3
        System.out.println(s.climbStairs(3));
    }

}
