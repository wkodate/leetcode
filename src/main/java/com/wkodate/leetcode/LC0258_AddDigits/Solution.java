package com.wkodate.leetcode.LC0258_AddDigits;

public class Solution {

    public int addDigits(int num) {
        while (true) {
            if (num < 10) {
                return num;
            }
            int n = 0;
            while (num != 0) {
                n += num % 10;
                num /= 10;
            }
            num = n;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addDigits(38));
    }

}
