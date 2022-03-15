package com.wkodate.leetcode.LC0409_LongestPalindrome;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int length = 0;
        boolean hasOdd = false;
        for (Integer value : map.values()) {
            if (value % 2 == 1) {
                hasOdd = true;
            }
            length += value / 2 * 2;
        }
        if (hasOdd) {
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(s.longestPalindrome("abccccdd"));
        // 3
        System.out.println(s.longestPalindrome("abcddefg"));
        // 3
        System.out.println(s.longestPalindrome("aaa"));
        // 4
        System.out.println(s.longestPalindrome("aaaa"));
        // 0
        System.out.println(s.longestPalindrome(""));
        // 7
        System.out.println(s.longestPalindrome("aaaAaaaa"));
    }

}
