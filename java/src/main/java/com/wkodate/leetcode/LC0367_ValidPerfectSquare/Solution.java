package com.wkodate.leetcode.LC0367_ValidPerfectSquare;

public class Solution {

    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while (left <= right) {
            long mid = (left + right) / 2;
            long midSquare = mid * mid;
            if (midSquare < num) {
                left = (int) (mid + 1);
            } else if (midSquare > num) {
                right = (int) (mid - 1);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isPerfectSquare(16));
        // false
        System.out.println(s.isPerfectSquare(14));
        //
        System.out.println(s.isPerfectSquare(2147483647));
    }

}
