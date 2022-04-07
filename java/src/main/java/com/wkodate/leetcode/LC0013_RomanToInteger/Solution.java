package com.wkodate.leetcode.LC0013_RomanToInteger;

public class Solution {

    public int romanToInt(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int sum = 0;
        if (s.contains("IV")) {
            sum += 4;
            s = s.replaceAll("IV", "");
        }
        if (s.contains("IX")) {
            sum += 9;
            s = s.replaceAll("IX", "");
        }
        if (s.contains("XL")) {
            sum += 40;
            s = s.replaceAll("XL", "");
        }
        if (s.contains("XC")) {
            sum += 90;
            s = s.replaceAll("XC", "");
        }
        if (s.contains("CD")) {
            sum += 400;
            s = s.replaceAll("CD", "");
        }
        if (s.contains("CM")) {
            sum += 900;
            s = s.replaceAll("CM", "");
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('I' == c) {
                sum += 1;
            } else if ('V' == c) {
                sum += 5;
            } else if ('X' == c) {
                sum += 10;
            } else if ('L' == c) {
                sum += 50;
            } else if ('C' == c) {
                sum += 100;
            } else if ('D' == c) {
                sum += 500;
            } else if ('M' == c) {
                sum += 1000;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 3
        System.out.println(solution.romanToInt("III"));
        // 4
        System.out.println(solution.romanToInt("IV"));
        // 9
        System.out.println(solution.romanToInt("IX"));
        // 58
        System.out.println(solution.romanToInt("LVIII"));
        // 1994
        System.out.println(solution.romanToInt("MCMXCIV"));
    }

}
