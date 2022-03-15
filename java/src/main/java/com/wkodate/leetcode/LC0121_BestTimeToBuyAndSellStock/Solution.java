package com.wkodate.leetcode.LC0121_BestTimeToBuyAndSellStock;

public class Solution {

    public int maxProfit(int[] prices) {
        int maxProf = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                continue;
            }
            if (prices[i] - min > maxProf) {
                maxProf = prices[i] - min;
            }
        }
        return maxProf;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(solution.maxProfit(new int[]{}));
    }

}
