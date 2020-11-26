package com.wkodate.leetcode.LC0389_FindTheDifference;

import java.util.Arrays;

public class Solution {

    public char findTheDifference(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        String sortedS = String.valueOf(charS);
        String sortedT = String.valueOf(charT);
        for (int i = 0; i < sortedS.length(); i++) {
            if (sortedS.charAt(i) != sortedT.charAt(i)) {
                return sortedT.charAt(i);
            }
        }
        return sortedT.charAt(sortedT.length() - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // e
        System.out.println(s.findTheDifference("abcd", "abcde"));
        // y
        System.out.println(s.findTheDifference("", "y"));
    }

}
