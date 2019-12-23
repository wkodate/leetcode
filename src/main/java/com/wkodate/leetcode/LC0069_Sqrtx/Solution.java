package com.wkodate.leetcode.LC0069_Sqrtx;

public class Solution {

    public int mySqrt(int x) {
        long i = 0;
        while (i * i <= x) {
            if (i * i == x) {
                return (int) i;
            }
            i++;
        }
        return (int) i - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.mySqrt(4));
        // 2
        System.out.println(s.mySqrt(8));
        // 0
        System.out.println(s.mySqrt(0));
        // 1
        System.out.println(s.mySqrt(1));
        // 46340
        System.out.println(s.mySqrt(2147483647));
    }

}
