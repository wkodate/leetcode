package com.wkodate.leetcode.LC0140_WordBreakII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    private List<String> dfs(String s, List<String> dict, HashMap<String, List<String>> cache) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        List<String> res = new ArrayList<>();
        if (s.isEmpty()) {
            res.add("");
            return res;
        }
        for (String word : dict) {
            //Check if the word starts with the dictionary word
            if (!s.startsWith(word)) {
                continue;
            }
            //Now we need to find all the subsets of in the String from the dict
            //and add them to a List
            List<String> subStr = dfs(s.substring(word.length()), dict, cache);
            //Now we have all the subsets, we will now start making our results
            for (String subs : subStr) {
                String space = " ";
                if (subs.isEmpty()) {
                    space = "";
                }
                res.add(word + space + subs);
            }
        }
        cache.put(s, res);
        return res;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<>());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [
        //  "cats and dog",
        //  "cat sand dog"
        //]
        System.out.println(s.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        // [
        //  "pine apple pen apple",
        //  "pineapple pen apple",
        //  "pine applepen apple"
        //]
        System.out.println(s.wordBreak("pineapplepenapple",
                                       Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
        // []
        System.out.println(s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        // []
        System.out.println(s.wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                              "aaaaaaaaaa")));
    }

}
