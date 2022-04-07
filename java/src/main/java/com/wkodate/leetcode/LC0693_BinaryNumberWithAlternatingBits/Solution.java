package com.wkodate.leetcode.LC0693_BinaryNumberWithAlternatingBits;

public class Solution {

    public boolean hasAlternatingBits(int n) {
        String binStr = Integer.toBinaryString(n);
        for (int i = 0; i < binStr.length() - 1; i++) {
            if (binStr.charAt(i) == binStr.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.hasAlternatingBits(5));
        // false
        System.out.println(s.hasAlternatingBits(7));
        // false
        System.out.println(s.hasAlternatingBits(11));
        // true
        System.out.println(s.hasAlternatingBits(10));
    }

}
