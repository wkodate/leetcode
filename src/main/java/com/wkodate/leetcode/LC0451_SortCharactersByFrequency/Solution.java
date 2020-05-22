package com.wkodate.leetcode.LC0451_SortCharactersByFrequency;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public String frequencySort(String s) {
        Map<Character, Integer> alphaFreq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            alphaFreq.put(c, alphaFreq.getOrDefault(c, 0) + 1);
        }

        Map<Integer, String> map = new TreeMap<>();
        for (char a : alphaFreq.keySet()) {
            int freq = alphaFreq.get(a);
            map.put(freq, map.getOrDefault(freq, "") + a);
        }
        StringBuilder ans = new StringBuilder();
        for (Integer freq : map.keySet()) {
            String[] val = map.get(freq).split("");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < val.length; i++) {
                for (int j = 0; j < freq; j++) {
                    sb.append(val[i]);
                }
            }
            ans.insert(0, sb);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // eert
        System.out.println(s.frequencySort("tree"));
        // cccaaa
        System.out.println(s.frequencySort("cccaaa"));
        // bbAa
        System.out.println(s.frequencySort("Aabb"));
    }

}
