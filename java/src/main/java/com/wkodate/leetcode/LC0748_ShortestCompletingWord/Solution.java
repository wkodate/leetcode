package com.wkodate.leetcode.LC0748_ShortestCompletingWord;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> lp = new HashMap<>();
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = Character.toLowerCase(licensePlate.charAt(i));
            if (Character.isLetter(c)) {
                lp.put(c, lp.getOrDefault(c, 0) + 1);
            }
        }

        String ans = "";
        for (String word : words) {
            String[] wordArr = word.split("");
            Arrays.sort(wordArr);
            StringBuilder sorted = new StringBuilder();
            for (String w : wordArr) {
                sorted.append(w.toLowerCase());
            }

            boolean containsAll = true;
            for (Map.Entry<Character, Integer> e : lp.entrySet()) {
                StringBuilder target = new StringBuilder();
                for (int i = 0; i < e.getValue(); i++) {
                    target.append(e.getKey());
                }
                if (!sorted.toString().contains(target.toString())) {
                    containsAll = false;
                    break;
                }
            }
            if (containsAll && ("".equals(ans) || word.length() < ans.length())) {
                ans = word;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // steps
        System.out.println(s.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        // pest
        System.out.println(s.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }

}
