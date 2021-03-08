package com.wkodate.leetcode.LC1332_RemovePalindromicSubsequences;

public class Solution {

    public int removePalindromeSub(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        boolean pal = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                pal = false;
                break;
            }
        }
        if (pal) {
            return 1;
        }
        return 2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.removePalindromeSub("ababa"));
        // 2
        System.out.println(s.removePalindromeSub("abb"));
        // 2
        System.out.println(s.removePalindromeSub("baabb"));
        // 0
        System.out.println(s.removePalindromeSub(""));
    }

}
