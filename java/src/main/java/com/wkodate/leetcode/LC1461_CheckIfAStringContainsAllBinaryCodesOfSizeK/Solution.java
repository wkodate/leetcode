package com.wkodate.leetcode.LC1461_CheckIfAStringContainsAllBinaryCodesOfSizeK;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    private static List<String> strs;

    private static void permutation(String str, String word, int k) {
        if (word.length() == k) {
            strs.add(word);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            permutation(str, word + str.charAt(i), k);
        }
    }

    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        strs = new ArrayList<>();
        permutation("01", "", k);
        for (int i = 0; i < s.length() - k + 1; i++) {
            set.add(s.substring(i, i + k));
        }
        for (int i = 0; i < strs.size(); i++) {
            if (!set.contains(strs.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.hasAllCodes("00110110", 2));
        // true
        System.out.println(s.hasAllCodes("00110", 2));
        // true
        System.out.println(s.hasAllCodes("0110", 1));
        // false
        System.out.println(s.hasAllCodes("0110", 2));
        // false
        System.out.println(s.hasAllCodes("0000000001011100", 4));
    }

}
