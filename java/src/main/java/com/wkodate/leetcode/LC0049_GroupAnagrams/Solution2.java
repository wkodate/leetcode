package com.wkodate.leetcode.LC0049_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String[] splitted = str.split("");
            Arrays.sort(splitted);
            String key = Arrays.toString(splitted);
            List<String> list = new ArrayList<>();
            if (map.containsKey(key)) {
                list = map.get(key);
            }
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        List<List<String>> ans = s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i).toString());
        }
    }

}
