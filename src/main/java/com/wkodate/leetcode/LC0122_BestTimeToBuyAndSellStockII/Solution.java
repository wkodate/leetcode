package com.wkodate.leetcode.LC0122_BestTimeToBuyAndSellStockII;

public class Solution {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= min) {
                min = prices[i];
                continue;
            }
            if (i < prices.length - 1 && prices[i] > prices[i + 1]) {
                profit += prices[i] - min;
                min = prices[i + 1];
            }
        }
        if (min < prices[prices.length - 1]) {
            profit += prices[prices.length - 1] - min;
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(solution.maxProfit(new int[]{}));
    }

}
