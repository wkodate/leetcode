package com.wkodate.leetcode.LC0709_ToLowerCase;

public class Solution {

    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.toLowerCase("Hello"));
        System.out.println(s.toLowerCase("here"));
        System.out.println(s.toLowerCase("LOVELY"));
        System.out.println(s.toLowerCase(""));
    }

}
