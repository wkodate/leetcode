package com.wkodate.leetcode.LC1556_ThousandSeparator;

public class Solution {

    public String thousandSeparator(int n) {
        String nstr = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nstr.length(); i++) {
            if (i != 0 && i % 3 == 0) {
                sb.append('.');
            }
            sb.append(nstr.charAt(nstr.length() - 1 - i));
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.thousandSeparator(987));
        System.out.println(s.thousandSeparator(1234));
        System.out.println(s.thousandSeparator(123456789));
        System.out.println(s.thousandSeparator(0));
    }

}
