package com.wkodate.leetcode.LC0151_ReverseWordsInAString;

public class Solution {

    public String reverseWords(String s) {
        s = s.trim();
        if ("".equals(s)) {
            return "";
        }
        String[] splitted = s.split(" +");
        String[] reversed = new String[splitted.length];
        for (int i = 0; i < splitted.length; i++) {
            reversed[splitted.length - i - 1] = splitted[i];
        }

        return String.join(" ", reversed);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // blue is sky the
        System.out.println(s.reverseWords("the sky is blue"));
        // world! hello
        System.out.println(s.reverseWords("  hello world!  "));
        // example good a
        System.out.println(s.reverseWords("a good   example"));
    }

}
