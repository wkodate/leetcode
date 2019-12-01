package com.wkodate.leetcode.LC0929_UniqueEmailAddresses;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return idx;
            }
            idx++;
        }
        return -1;
    }

    public static void main(String[] args) {
    }

}
