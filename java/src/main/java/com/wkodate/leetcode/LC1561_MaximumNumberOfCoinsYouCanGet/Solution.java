package com.wkodate.leetcode.LC1561_MaximumNumberOfCoinsYouCanGet;

import java.util.Arrays;

public class Solution {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum = 0;
        for (int i = 0; i < piles.length / 3; i++) {
            sum += piles[piles.length - 2 * (i + 1)];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 18
        System.out.println(s.maxCoins(new int[] { 9, 8, 7, 6, 5, 1, 2, 3, 4 }));
        // 9
        System.out.println(s.maxCoins(new int[] { 2, 4, 1, 2, 7, 8 }));
        // 4
        System.out.println(s.maxCoins(new int[] { 2, 4, 5 }));
    }

}
