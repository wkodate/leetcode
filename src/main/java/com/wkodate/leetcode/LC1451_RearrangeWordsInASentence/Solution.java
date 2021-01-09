package com.wkodate.leetcode.LC1451_RearrangeWordsInASentence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Solution {

    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        Map<Integer, List<Integer>> lenListMap = new HashMap<>();
        int maxLen = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            List<Integer> l;
            if (lenListMap.containsKey(word.length())) {
                l = lenListMap.get(word.length());
            } else {
                l = new ArrayList<>();
            }
            l.add(i);
            lenListMap.put(word.length(), l);
            maxLen = Math.max(word.length(), maxLen);
        }
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 1; i <= maxLen; i++) {
            if (!lenListMap.containsKey(i)) {
                continue;
            }
            List<Integer> list = lenListMap.get(i);
            for (int j = 0; j < list.size(); j++) {
                String word = words[list.get(j)];
                if (sj.length() == 0) {
                    sj.add(word.substring(0, 1).toUpperCase() + word.substring(1));
                } else {
                    sj.add(word.toLowerCase());
                }
            }
        }
        return sj.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // Is cool leetcode
        System.out.println(s.arrangeWords("Leetcode is cool"));
    }

}
