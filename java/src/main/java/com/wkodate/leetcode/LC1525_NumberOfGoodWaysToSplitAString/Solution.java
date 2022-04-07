package com.wkodate.leetcode.LC1525_NumberOfGoodWaysToSplitAString;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numSplits(String s) {
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> map1 = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
            if (map2.get(c) == 1) {
                map2.remove(c);
            } else {
                map2.put(c, map2.get(c) - 1);
            }
            if (map1.size() == map2.size()) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.numSplits("aacaba"));
        // 1
        System.out.println(s.numSplits("abcd"));
        // 4
        System.out.println(s.numSplits("aaaaa"));
        // 2
        System.out.println(s.numSplits("acbadbaada"));
    }

}
