package com.wkodate.leetcode.LC1475_FinalPricesWithASpecialDiscountInAShop;

import java.util.Arrays;

public class Solution {

    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            ans[i] = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    ans[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.finalPrices(new int[]{8, 4, 6, 2, 3})));
        System.out.println(Arrays.toString(s.finalPrices(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(s.finalPrices(new int[]{10, 1, 1, 6})));
    }

}
