package com.wkodate.leetcode.LC0434_NumberOfSegmentsInAString;

public class Solution {

    public int countSegments(String s) {
        s = s.trim();
        if ("".equals(s)) {
            return 0;
        }
        return s.split(" +").length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.countSegments("Hello, my name is John"));
        // 0
        System.out.println(s.countSegments(""));
        // 6
        System.out.println(s.countSegments(", , , ,        a, eaefa"));
        // 2
        System.out.println(s.countSegments("    foo    bar"));
        // 0
        System.out.println(s.countSegments("    "));
    }

}
