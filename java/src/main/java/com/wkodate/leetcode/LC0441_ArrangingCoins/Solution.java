package com.wkodate.leetcode.LC0441_ArrangingCoins;

public class Solution {

    public int arrangeCoins(int n) {
        int i = 1;
        while (i <= n) {
            n -= i;
            i++;
        }
        return i - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.arrangeCoins(5));
        // 3
        System.out.println(s.arrangeCoins(8));
    }

}
