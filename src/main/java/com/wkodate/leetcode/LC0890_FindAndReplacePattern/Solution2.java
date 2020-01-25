package com.wkodate.leetcode.LC0890_FindAndReplacePattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

    public boolean match(String word, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!map.containsKey(w)) {
                map.put(w, p);
            }
            if (map.get(w) != p) {
                return false;
            }
        }

        boolean[] seen = new boolean[26];
        for (char p : map.values()) {
            if (seen[p - 'a']) {
                return false;
            }
            seen[p - 'a'] = true;
        }
        return true;
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) {
                ans.add(word);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // ["mee", "aqq"]
        System.out.println(s.findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
    }

}
