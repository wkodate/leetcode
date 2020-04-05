package com.wkodate.leetcode.LC0122_BestTimeToBuyAndSellStockII;

public class Solution2 {

    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] > 0) {
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 7
        System.out.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        // 4
        System.out.println(s.maxProfit(new int[]{1, 2, 3, 4, 5}));
        // 0
        System.out.println(s.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

}
