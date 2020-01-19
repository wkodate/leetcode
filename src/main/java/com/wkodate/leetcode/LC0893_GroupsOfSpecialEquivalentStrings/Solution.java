package com.wkodate.leetcode.LC0893_GroupsOfSpecialEquivalentStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String word : A) {
            int[] odd = new int[26];
            int[] even = new int[26];
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (i % 2 == 0) {
                    even[c - 'a']++;
                } else {
                    odd[c - 'a']++;
                }
            }
            String str = Arrays.toString(odd) + Arrays.toString(even);
            set.add(str);
        }
        return set.sｇize();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.numSpecialEquivGroups(new String[]{"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"}));
        // 3
        System.out.println(s.numSpecialEquivGroups(new String[]{"abc", "acb", "bac", "bca", "cab", "cba"}));
    }

}
