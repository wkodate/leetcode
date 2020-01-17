package com.wkodate.leetcode.LC0696_CountBinarySubstrings;

public class Solution {

    public int countBinarySubstrings(String s) {
        int ans = 0;
        int prevGroup = 0;
        int currentGroup = 1;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) != s.charAt(i+1)) {
                ans += Math.min(prevGroup, currentGroup);
                prevGroup = currentGroup;
                currentGroup = 1;
            } else {
                currentGroup++;
            }
        }
        return ans + Math.min(prevGroup, currentGroup);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countBinarySubstrings("00110011"));
        System.out.println(s.countBinarySubstrings("10101"));
    }

}
