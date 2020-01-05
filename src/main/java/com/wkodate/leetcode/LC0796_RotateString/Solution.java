package com.wkodate.leetcode.LC0796_RotateString;

public class Solution {

    public boolean rotateString(String A, String B) {
        if ("".equals(A) && "".equals(B)) {
            return true;
        }
        if ("".equals(A) || "".equals(B)) {
            return false;
        }
        for (int i = 0; i < A.length(); i++) {
            String[] splitted = A.split("", 2);
            A = splitted[1] + splitted[0];
            if (A.equals(B)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.rotateString("abcde", "cdeab"));
        // false
        System.out.println(s.rotateString("abcde", "abced"));
        // true
        System.out.println(s.rotateString("", ""));
    }

}
