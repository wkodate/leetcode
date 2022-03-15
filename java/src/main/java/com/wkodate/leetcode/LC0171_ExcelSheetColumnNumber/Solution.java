package com.wkodate.leetcode.LC0171_ExcelSheetColumnNumber;

public class Solution {

    public int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + c;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 28
        System.out.println(s.titleToNumber("AB"));
        // 53
        System.out.println(s.titleToNumber("BA"));
        // 703
        System.out.println(s.titleToNumber("AAA"));
    }

}
