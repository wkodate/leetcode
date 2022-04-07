package com.wkodate.leetcode.LC0720_LongestWordInDictionary;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public String longestWord(String[] words) {
        String ans = "";
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        for (String word : words) {
            if (word.length() > ans.length()
                    || (word.length() == ans.length() && word.compareTo(ans) < 0)) {
                boolean contains = true;
                for (int i = 1; i < word.length(); i++) {
                    if (!set.contains(word.substring(0, i))) {
                        contains = false;
                        break;
                    }
                }
                if (contains) {
                    ans = word;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // world
        System.out.println(s.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        // apple
        System.out.println(s.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        // english
        System.out.println(s.longestWord(new String[]{
                "t", "ti", "tig", "tige", "tiger",
                "e", "en", "eng", "engl", "engli", "englis", "english",
                "h", "hi", "his", "hist", "histo", "histor", "history"}));
        // latte
        System.out.println(s.longestWord(new String[]{
                "m", "mo", "moc", "moch", "mocha",
                "l", "la", "lat", "latt", "latte",
                "c", "ca", "cat"}));
    }

}
