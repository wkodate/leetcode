package com.wkodate.leetcode.LC0172_FactorialTrailingZeroes;

public class Solution {

    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.trailingZeroes(3));
        // 1
        System.out.println(s.trailingZeroes(5));
        // 2
        System.out.println(s.trailingZeroes(10));
        // 0
        System.out.println(s.trailingZeroes(0));
        // 1
        System.out.println(s.trailingZeroes(7));
        // 2
        System.out.println(s.trailingZeroes(13));
        // 7
        System.out.println(s.trailingZeroes(30));
    }

}
