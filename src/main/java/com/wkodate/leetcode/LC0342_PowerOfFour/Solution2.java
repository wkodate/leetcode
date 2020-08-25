package com.wkodate.leetcode.LC0342_PowerOfFour;

public class Solution2 {

    public boolean isPowerOfFour(int num) {
        if (num == 0) {
            return false;
        }
        while (num % 4 == 0) {
            num /= 4;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // false
        System.out.println(s.isPowerOfFour(0));
        // true
        System.out.println(s.isPowerOfFour(1));
        // false
        System.out.println(s.isPowerOfFour(2));
        // true
        System.out.println(s.isPowerOfFour(4));
        // true
        System.out.println(s.isPowerOfFour(16));
        // false
        System.out.println(s.isPowerOfFour(5));
    }

}
