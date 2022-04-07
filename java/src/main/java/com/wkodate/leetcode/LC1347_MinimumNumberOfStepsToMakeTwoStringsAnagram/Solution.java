package com.wkodate.leetcode.LC1347_MinimumNumberOfStepsToMakeTwoStringsAnagram;

public class Solution {

    public int minSteps(String s, String t) {
        int[] sch = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sch[s.charAt(i) - 'a']++;
        }
        int[] tch = new int[26];
        for (int i = 0; i < t.length(); i++) {
            tch[t.charAt(i) - 'a']++;
        }
        int cnt = 0;
        for (int i = 0; i < tch.length; i++) {
            if (tch[i] == 0) {
                continue;
            }
            cnt += Math.min(tch[i], sch[i]);
        }
        return t.length() - cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.minSteps("leetcode", "practice"));
        // 1
        System.out.println(s.minSteps("bab", "aba"));
        // 0
        System.out.println(s.minSteps("anagram", "mangaar"));
        // 0
        System.out.println(s.minSteps("xxyyzz", "xxyyzz"));
        // 4
        System.out.println(s.minSteps("friend", "family"));
    }

}
