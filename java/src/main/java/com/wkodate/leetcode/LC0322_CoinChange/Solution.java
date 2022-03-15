package com.wkodate.leetcode.LC0322_CoinChange;

import java.util.Arrays;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if (dp[amount] > amount) {
            return -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.coinChange(new int[] { 1, 2, 5 }, 11));
        // -1
        System.out.println(s.coinChange(new int[] { 2 }, 3));
        // 0
        System.out.println(s.coinChange(new int[] { 1 }, 0));
        // 1
        System.out.println(s.coinChange(new int[] { 1 }, 1));
        // 2
        System.out.println(s.coinChange(new int[] { 1 }, 2));
    }

}
