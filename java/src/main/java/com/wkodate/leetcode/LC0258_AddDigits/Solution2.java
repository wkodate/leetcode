package com.wkodate.leetcode.LC0258_AddDigits;

public class Solution2 {

    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        if (num % 9 == 0) {
            return 9;
        }
        return num % 9;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.addDigits(38));
    }

}
