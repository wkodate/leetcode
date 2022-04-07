package com.wkodate.leetcode.LC0438_FindAllAnagramsInAString;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) {
            return ans;
        }
        int[] map = new int[26];
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i) - 'a']++;
        }
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            // valid anagram
            if (map[s.charAt(end) - 'a'] > 0) {
                map[s.charAt(end++) - 'a']--;
                // window size equal to size of P
                if (end - start == p.length()) {
                    ans.add(start);
                }
            } else if (start == end) {
                // window is of size 0
                start++;
                end++;
            } else {
                // decrease window size
                map[s.charAt(start++) - 'a']++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,6]
        System.out.println(s.findAnagrams("cbaebabacd", "abc"));
        // [0,1,2]
        System.out.println(s.findAnagrams("abab", "ab"));
        // []
        System.out.println(s.findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));
    }

}
