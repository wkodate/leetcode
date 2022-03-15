package com.wkodate.leetcode.LC0520_DetectCapital;

public class Solution {

    public boolean detectCapitalUse(String word) {
        if (Character.isLowerCase(word.charAt(0))) {
            return word.equals(word.toLowerCase());
        }
        if (word.length() <= 1) {
            return true;
        }
        word = word.substring(1);
        return word.equals(word.toLowerCase()) || word.equals(word.toUpperCase());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // True
        System.out.println(s.detectCapitalUse("USA"));
        // False
        System.out.println(s.detectCapitalUse("FlaG"));
    }

}
