package com.wkodate.leetcode.LC1417_ReformatTheString;

public class Solution {

    private String join(String a, String b) {
        StringBuilder joined = new StringBuilder();
        for (int i = 0; i < b.length(); i++) {
            joined.append(a, i, i + 1);
            joined.append(b, i, i + 1);
        }
        if (a.length() > b.length()) {
            joined.append(a, a.length() - 1, a.length());
        }
        return joined.toString();
    }

    public String reformat(String s) {
        StringBuilder letters = new StringBuilder();
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                letters.append(s.charAt(i));
            } else {
                digits.append(s.charAt(i));
            }
        }
        if (Math.abs(letters.length() - digits.length()) > 1) {
            return "";
        }
        if (letters.length() >= digits.length()) {
            return join(letters.toString(), digits.toString());
        }
        return join(digits.toString(), letters.toString());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "0a1b2c"
        System.out.println(s.reformat("a0b1c2"));
        // ""
        System.out.println(s.reformat("leetcode"));
        // ""
        System.out.println(s.reformat("1229857369"));
        // "c2o0v1i9d"
        System.out.println(s.reformat("covid2019"));
        // "1a2b3"
        System.out.println(s.reformat("ab123"));
    }

}
