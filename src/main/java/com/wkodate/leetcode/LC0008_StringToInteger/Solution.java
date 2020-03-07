package com.wkodate.leetcode.LC0008_StringToInteger;

public class Solution {

    private String removeZero(String n) {
        StringBuilder sb = new StringBuilder(n);
        while (sb.length() > 1) {
            char c = sb.charAt(0);
            if (c != '0') {
                break;
            }
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public int myAtoi(String str) {
        str = str.trim();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' '
                    || !Character.isDigit(c) && c != '-' && c != '+') {
                break;
            }
            sb.append(c);
        }
        String ans = sb.toString();
        if ("".equals(ans)) {
            return 0;
        }
        String sign = ans.substring(0, 1);
        String num = ans.substring(1);
        if ("-".equals(sign)) {
            num = removeZero(num);
        } else if ("+".equals(sign)) {
            sign = "";
            num = removeZero(num);
        } else {
            sign = "";
            num = removeZero(ans);
        }
        if ("-".equals(ans) || "+".equals(ans) || num.contains("+") || num.contains("-")) {
            return 0;
        }
        if ("-".equals(sign) && num.length() > 10) {
            return Integer.MIN_VALUE;
        }
        if (!"-".equals(sign) && num.length() > 10) {
            return Integer.MAX_VALUE;
        }
        if ("-".equals(sign) && -1 * Long.valueOf(num) < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (!"-".equals(sign) && Long.valueOf(num) > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return Integer.parseInt(ans);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // -5?
        System.out.println(s.myAtoi("-5-"));
        // 0
        System.out.println(s.myAtoi("0-1"));
        // 42
        System.out.println(s.myAtoi("42"));
        // -42
        System.out.println(s.myAtoi("   -42"));
        // 4193
        System.out.println(s.myAtoi("4193 with words"));
        // 0
        System.out.println(s.myAtoi("words and 987"));
        // -2147483648
        System.out.println(s.myAtoi("-91283472332"));
        // 0
        System.out.println(s.myAtoi("-"));
        // 0
        System.out.println(s.myAtoi("+"));
        // 1
        System.out.println(s.myAtoi("+1"));
        // 0
        System.out.println(s.myAtoi("+-2"));
        // 2147483647
        System.out.println(s.myAtoi("20000000000000000000"));
        // 12345678
        System.out.println(s.myAtoi("  0000000000012345678"));
        // -1
        System.out.println(s.myAtoi("-000000000000001"));
        // 3
        System.out.println(s.myAtoi("3.14159"));
        // -2147483648
        System.out.println(s.myAtoi("-2147483648"));
    }

}
