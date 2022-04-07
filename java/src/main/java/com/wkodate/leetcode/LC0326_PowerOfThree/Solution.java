package com.wkodate.leetcode.LC0326_PowerOfThree;

public class Solution {

    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 3 != 0) {
            return false;
        }
        return isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // true
        System.out.println(solution.isPowerOfThree(27));
        // false
        System.out.println(solution.isPowerOfThree(0));
        // true
        System.out.println(solution.isPowerOfThree(9));
        // false
        System.out.println(solution.isPowerOfThree(45));
        // true
        System.out.println(solution.isPowerOfThree(1));
    }

}
