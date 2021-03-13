package com.wkodate.leetcode.LC0322_CoinChange;

public class Solution {

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        if (min == Integer.MAX_VALUE) {
            count[rem - 1] = -1;
        } else {
            count[rem - 1] = min;
        }
        return count[rem - 1];
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
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
