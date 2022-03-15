package com.wkodate.leetcode.LC1662_CheckIfTwoStringArraysAreEquivalent;

public class Solution {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            sb1.append(word1[i]);
        }
        for (int i = 0; i < word2.length; i++) {
            sb2.append(word2[i]);
        }
        return sb1.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.arrayStringsAreEqual(new String[] { "ab", "c" }, new String[] { "a", "bc" }));
        System.out.println(s.arrayStringsAreEqual(new String[] { "a", "cb" }, new String[] { "ab", "c" }));
        System.out.println(
                s.arrayStringsAreEqual(new String[] { "abc", "d", "defg" }, new String[] { "abcddefg" }));
    }

}
