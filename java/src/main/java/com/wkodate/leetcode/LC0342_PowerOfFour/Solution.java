package com.wkodate.leetcode.LC0342_PowerOfFour;

public class Solution {

    public boolean isPowerOfFour(int num) {
        if (num <= 0 || Integer.bitCount(num) != 1) {
            return false;
        }
        String bitStr = Integer.toBinaryString(num);
        for (int i = 0; i < bitStr.length(); i++) {
            char c = bitStr.charAt(bitStr.length() - i - 1);
            if (c == '1') {
                return i % 2 == 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isPowerOfFour(16));
        // false
        System.out.println(s.isPowerOfFour(5));
        // false
        System.out.println(s.isPowerOfFour(-2147483648));
        // false
        System.out.println(s.isPowerOfFour(2));
    }

}
