package com.wkodate.leetcode.LC0884_UncommonWordsFromTwoSentences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        String[] aWord = A.split(" ");
        String[] bWord = B.split(" ");
        for (String word : aWord) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word : bWord) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["sweet", "sour"]
        System.out.println(Arrays.toString(s.uncommonFromSentences("this apple is sweet", "this apple is sour")));
        // ["banana"]
        System.out.println(Arrays.toString(s.uncommonFromSentences("apple apple", "banana")));
    }

}
