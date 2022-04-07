package com.wkodate.leetcode.LC0819_MostCommonWord;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] paras = paragraph.split(" |\\p{Punct}");
        Map<String, Integer> paraMap = new HashMap<>();
        for (String para : paras) {
            if ("".equals(para)) {
                continue;
            }
            para = para.toLowerCase();
            paraMap.put(para, paraMap.getOrDefault(para, 0) + 1);
        }
        Set<String> bans = new HashSet<>();
        for (String ban : banned) {
            bans.add(ban);
        }
        String maxk = "";
        int maxv = 0;
        for (Map.Entry<String, Integer> e : paraMap.entrySet()) {
            if (!bans.contains(e.getKey()) && e.getValue() > maxv) {
                maxk = e.getKey();
                maxv = e.getValue();
            }
        }
        return maxk;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ball
        System.out.println(s.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        // b
        System.out.println(s.mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
    }

}
