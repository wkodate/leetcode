package com.wkodate.leetcode.LC0392_IsSubsequence;

public class Solution {

    public boolean isSubsequence(String s, String t) {
        int is = 0;
        int it = 0;
        while (is < s.length() && it < t.length()) {
            if (s.charAt(is) == t.charAt(it)) {
                is++;
            }
            it++;
        }
        return is == s.length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isSubsequence("", "ahbgdc"));
        // false
        System.out.println(s.isSubsequence("b", "c"));
        // true
        System.out.println(s.isSubsequence("abc", "ahbgdc"));
        // false
        System.out.println(s.isSubsequence("axc", "ahbgdc"));
    }

}
