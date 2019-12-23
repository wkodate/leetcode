package com.wkodate.leetcode.LC0009_PalindromeNumber;

public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        long num = 0;
        int i = x;
        while (i != 0) {
            num = num * 10 + i % 10;
            i /= 10;
        }
        return x == num;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isPalindrome(121));
        // false
        System.out.println(s.isPalindrome(-121));
        // false
        System.out.println(s.isPalindrome(10));
        // true
        System.out.println(s.isPalindrome(0));
        // false (7463847412)
        System.out.println(s.isPalindrome(2147483647));
    }

}
