package com.wkodate.leetcode.LC0791_CustomSortString;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }

        char[] tcharr = T.toCharArray();
        for (int i = 1; i < T.length(); i++) {
            for (int j = i; j > 0; j--) {
                char cj1 = tcharr[j];
                char cj2 = tcharr[j - 1];
                if (!map.containsKey(cj1)) {
                    continue;
                }
                if (!map.containsKey(cj2) || map.get(cj2) > map.get(cj1)) {
                    tcharr[j] = cj2;
                    tcharr[j - 1] = cj1;
                }
            }
        }
        return new String(tcharr);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.customSortString("exv", "xwvee"));
        // cbad
        System.out.println(s.customSortString("cba", "abcd"));

    }

}
