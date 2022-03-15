package com.wkodate.leetcode.LC0125_ValidPalindrome;

public class Solution2 {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        String str = sb.toString();
        String reversed = sb.reverse().toString();
        for (int i = 0; i < sb.length(); i++) {
            if (str.charAt(i) != reversed.charAt(i)) {
                return false;
            };
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        //true
        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
        // false
        System.out.println(s.isPalindrome("race a car"));
    }

}
