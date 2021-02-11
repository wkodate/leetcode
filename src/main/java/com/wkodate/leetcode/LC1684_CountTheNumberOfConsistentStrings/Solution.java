package com.wkodate.leetcode.LC1684_CountTheNumberOfConsistentStrings;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedSet = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            allowedSet.add(allowed.charAt(i));
        }
        int cnt = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean consistent = true;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (!allowedSet.contains(c)) {
                    consistent = false;
                    break;
                }
            }
            if (consistent) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.countConsistentStrings("ab", new String[] { "ad", "bd", "aaab", "baa", "badab" }));
        // 7
        System.out.println(s.countConsistentStrings(
                "abc", new String[] { "a", "b", "c", "ab", "ac", "bc", "abc" }));
        // 4
        System.out.println(s.countConsistentStrings(
                "cad", new String[] { "cc", "acd", "b", "ba", "bac", "bad", "ac", "d" }));
    }

}
