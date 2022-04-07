package com.wkodate.leetcode.LC0003_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= start) {
                max = Math.max(max, i - start);
                start = map.get(c) + 1;
                map.put(c, i);
                continue;
            }
            map.put(c, i);
        }
        return Math.max(max, s.length() - start);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        // 1
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        // 3
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
        // 1
        System.out.println(s.lengthOfLongestSubstring(" "));
        // 3
        System.out.println(s.lengthOfLongestSubstring("dvdf"));
        // 5
        System.out.println(s.lengthOfLongestSubstring("tmmzuxt"));
    }

}
