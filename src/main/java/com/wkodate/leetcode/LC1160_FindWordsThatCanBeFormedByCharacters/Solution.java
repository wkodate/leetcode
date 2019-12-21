package com.wkodate.leetcode.LC1160_FindWordsThatCanBeFormedByCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            Map<Character, Integer> mapWord = new HashMap<>();
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (mapWord.containsKey(c)) {
                    mapWord.put(c, mapWord.get(c) + 1);
                } else {
                    mapWord.put(c, 1);
                }
            }
            boolean contains = true;
            for (Character c : mapWord.keySet()) {
                if (!map.containsKey(c) || map.get(c) < mapWord.get(c)) {
                    contains = false;
                    break;
                }
            }
            if (!contains) {
                continue;
            }
            count += words[i].length();
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        // 10
        System.out.println(s.countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }

}
