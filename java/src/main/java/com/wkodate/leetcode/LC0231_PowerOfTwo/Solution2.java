package com.wkodate.leetcode.LC0231_PowerOfTwo;

public class Solution2 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // true
        System.out.println(s.isPowerOfTwo(1));
        // true
        System.out.println(s.isPowerOfTwo(16));
        // false
        System.out.println(s.isPowerOfTwo(218));
        // false
        System.out.println(s.isPowerOfTwo(-2147483648));
    }

}
