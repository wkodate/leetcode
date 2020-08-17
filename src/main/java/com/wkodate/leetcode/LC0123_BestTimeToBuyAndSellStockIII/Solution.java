package com.wkodate.leetcode.LC0123_BestTimeToBuyAndSellStockIII;

public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 13
        System.out.println(s.maxProfit(new int[] { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 }));
        // 6
        System.out.println(s.maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }));
        // 4
        System.out.println(s.maxProfit(new int[] { 1, 2, 3, 4, 5 }));
        // 0
        System.out.println(s.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
        // 0
        System.out.println(s.maxProfit(new int[] {}));
        // 0
        System.out.println(s.maxProfit(new int[] { 1 }));
    }

}
