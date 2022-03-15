package com.wkodate.leetcode.LC0187_RepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > 1) {
                ans.add(e.getKey());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["AAAAACCCCC","CCCCCAAAAA"]
        System.out.println(s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        // ["AAAAAAAAAA"]
        System.out.println(s.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
        // []
        System.out.println(s.findRepeatedDnaSequences("AAAAAAAAAA"));
        // ["AAAAAAAAAA"]
        System.out.println(s.findRepeatedDnaSequences("AAAAAAAAAAA"));

    }

}
