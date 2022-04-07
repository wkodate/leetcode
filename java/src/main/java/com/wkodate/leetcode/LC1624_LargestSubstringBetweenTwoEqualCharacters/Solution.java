package com.wkodate.leetcode.LC1624_LargestSubstringBetweenTwoEqualCharacters;

import java.util.Arrays;

public class Solution {

    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLen = -1;
        int[] alpFirst = new int[26];
        Arrays.fill(alpFirst, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (alpFirst[c - 'a'] == -1) {
                alpFirst[c - 'a'] = i;
            } else {
                maxLen = Math.max(i - alpFirst[c - 'a'] - 1, maxLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.maxLengthBetweenEqualCharacters("aa"));
        // 2
        System.out.println(s.maxLengthBetweenEqualCharacters("abca"));
        // -1
        System.out.println(s.maxLengthBetweenEqualCharacters("cbzxy"));
        // 4
        System.out.println(s.maxLengthBetweenEqualCharacters("cabbac"));
    }

}
