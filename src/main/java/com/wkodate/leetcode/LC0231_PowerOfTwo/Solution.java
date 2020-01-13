package com.wkodate.leetcode.LC0231_PowerOfTwo;

public class Solution {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        String binStr = Integer.toBinaryString(n);
        boolean hasOne = false;
        for (int i = 0; i < binStr.length(); i++) {
            if (binStr.charAt(i) == '1') {
                if (hasOne) {
                    return false;
                }
                hasOne = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isPowerOfTwo(1));
        // true
        System.out.println(s.isPowerOfTwo(16));
        // false
        System.out.println(s.isPowerOfTwo(218));
        // false
        System.out.println(s.isPowerOfTwo(0));
        // false
        System.out.println(s.isPowerOfTwo(-2147483648));
    }

}
