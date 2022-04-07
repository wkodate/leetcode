package com.wkodate.leetcode.LC0387_FirstUniqueCharacterInAString;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) <= 1) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // return 0
        System.out.println(s.firstUniqChar("leetcode"));
        // return 2
        System.out.println(s.firstUniqChar("loveleetcode"));
    }

}
