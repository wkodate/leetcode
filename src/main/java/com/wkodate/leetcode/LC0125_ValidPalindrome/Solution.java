package com.wkodate.leetcode.LC0125_ValidPalindrome;

public class Solution {

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        String[] sarr = s.split("");
        for (int i = 0; i < s.length() / 2; i++) {
            if (!sarr[i].equals(sarr[s.length() - i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome("0P"));
    }

}
