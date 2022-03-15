package com.wkodate.leetcode.LC0953_VerifyingAnAlienDictionary;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            int idx = 0;
            String a = words[i];
            String b = words[i + 1];
            int len = Math.min(words[i].length(), words[i + 1].length());
            while (idx < len) {
                int orderA = map.get(a.charAt(idx));
                int orderB = map.get(b.charAt(idx));
                if (orderA < orderB) {
                    break;
                } else if (orderA > orderB) {
                    return false;
                }
                idx++;
            }
            if (idx == len && a.length() > b.length()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        // false
        System.out.println(s.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        // false
        System.out.println(s.isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

}
