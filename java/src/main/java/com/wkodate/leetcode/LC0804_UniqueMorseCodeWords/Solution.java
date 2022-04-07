package com.wkodate.leetcode.LC0804_UniqueMorseCodeWords;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(morse[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }

}
