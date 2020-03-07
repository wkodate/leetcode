package com.wkodate.leetcode.LC0008_StringToInteger;

public class Solution2 {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        if (str.equals("")) {
            return 0;
        }
        char firstChar = str.charAt(0);
        int sign = 1;
        int start = 0;
        int len = str.length();
        long sum = 0;
        if (firstChar == '+') {
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < len; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) sum * sign;
            }
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) sum * sign;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // -5
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
        System.out.println(s.myAtoi(" "));
        System.out.println(s.myAtoi("  "));
    }

}
