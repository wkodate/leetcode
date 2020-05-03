package com.wkodate.leetcode.LC0383_RansomNote;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            int val = map.get(c) - 1;
            if (val == 0) {
                map.remove(c);
            } else {
                map.put(c, val);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.canConstruct("a", "b"));
        // false
        System.out.println(s.canConstruct("aa", "ab"));
        // true
        System.out.println(s.canConstruct("aa", "aab"));
    }

}
