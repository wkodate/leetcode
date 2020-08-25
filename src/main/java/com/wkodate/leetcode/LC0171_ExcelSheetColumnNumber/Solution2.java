package com.wkodate.leetcode.LC0171_ExcelSheetColumnNumber;

public class Solution2 {

    public int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(s.length() - 1 - i);
            sum += Math.pow(26, i) * (c - 'A' + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 1
        System.out.println(s.titleToNumber("A"));
        // 28
        System.out.println(s.titleToNumber("AB"));
        // 701
        System.out.println(s.titleToNumber("ZY"));
    }

}
