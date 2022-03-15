package com.wkodate.leetcode.LC0521_LongestUncommonSubsequenceI;

public class Solution {

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.findLUSlength("aba", "cdc"));
        // -1
        System.out.println(s.findLUSlength("aaa", "aaa"));
        // 17
        System.out.println(s.findLUSlength("aefawfawfawfaw", "aefawfeawfwafwaef"));
        // 3
        System.out.println(s.findLUSlength("aba", "cab"));
    }

}
