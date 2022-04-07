package com.wkodate.leetcode.LC0678_ValidParenthesisString;

public class Solution {

    public boolean checkValidString(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left += 1;
                right += 1;
            } else if (c == ')') {
                left -= 1;
                right -= 1;
            } else {
                left -= 1;
                right += 1;
            }
            if (right < 0) {
                break;
            }
            left = Math.max(left, 0);
        }
        return left == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // False
        System.out.println(s.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
        // True
        System.out.println(s.checkValidString("()"));
        // True
        System.out.println(s.checkValidString("(*)"));
        // True
        System.out.println(s.checkValidString("(*))"));
        // True
        System.out.println(s.checkValidString(""));
    }

}
