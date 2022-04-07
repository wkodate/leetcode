package com.wkodate.leetcode.LC0771_JewelsAndStones;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numJewelsInStones(String J, String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int sum = 0;
        for (int i = 0; i < J.length(); i++) {
            char c = J.charAt(i);
            if (map.containsKey(c)) {
                sum += map.get(c);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.numJewelsInStones("aA", "aAAbbbb"));
        // 0
        System.out.println(s.numJewelsInStones("z", "ZZ"));
    }

}
