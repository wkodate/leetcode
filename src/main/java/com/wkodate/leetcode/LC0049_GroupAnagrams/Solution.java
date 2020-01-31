package com.wkodate.leetcode.LC0049_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        for (String str : strs) {
            String[] splitted = str.split("");
            Arrays.sort(splitted);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < splitted.length; i++) {
                sb.append(splitted[i]);
            }
            String key = sb.toString();
            if (map.containsKey(key)) {
                List<String> list = ans.get(map.get(key));
                list.add(str);
                ans.set(map.get(key), list);
            } else {
                map.put(key, idx++);
                List<String> list = new ArrayList<>();
                list.add(str);
                ans.add(list);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [["ate","eat","tea"], ["nat","tan"], ["bat"]]
        System.out.println(s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

}
