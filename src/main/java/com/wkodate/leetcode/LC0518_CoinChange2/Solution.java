package com.wkodate.leetcode.LC0518_CoinChange2;

public class Solution {

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int j = 1; j <= coins.length; j++) {
            // number ways of selecting for amount zero is 1
            dp[j][0] = 1;
            for (int i = 1; i <= amount; i++) {
                // exclude current coin
                dp[j][i] = dp[j - 1][i];
                // check if amount  >= to the current i`th coin
                if (i - coins[j - 1] >= 0) {
                    // include current coin
                    dp[j][i] += dp[j][i - coins[j - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.change(5, new int[] { 1, 2, 5 }));
        // 0
        System.out.println(s.change(3, new int[] { 2 }));
        // 1
        System.out.println(s.change(10, new int[] { 10 }));
    }

}
