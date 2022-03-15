package com.wkodate.leetcode.LC1657_DetermineIfTwoStringsAreClose;

public class Solution {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] freq1 = new int[28];
        int[] freq2 = new int[28];
        for (int i = 0; i < word1.length(); i++) {
            freq1[word1.charAt(i) - 'a']++;
            freq2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < freq1.length; i++) {
            if (freq1[i] != 0 && freq2[i] == 0 || freq1[i] == 0 && freq2[i] != 0) {
                return false;
            }
        }
        int[] cnt1 = new int[100001];
        int[] cnt2 = new int[100001];
        for (int i = 0; i < freq1.length; i++) {
            cnt1[freq1[i]]++;
            cnt2[freq2[i]]++;
        }
        for (int i = 0; i < cnt1.length; i++) {
            if (cnt1[i] != cnt2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.closeStrings("abc", "bca"));
        // false
        System.out.println(s.closeStrings("a", "aa"));
        // true
        System.out.println(s.closeStrings("cabbba", "abbccc"));
        // false
        System.out.println(s.closeStrings("cabbba", "aabbss"));
        // false
        System.out.println(s.closeStrings("uau", "ssx"));
    }

}
