package com.wkodate.leetcode.LC1282_GroupThePeopleGivenTheGroupSizeTheyBelongTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> l;
            if (map.containsKey(groupSizes[i])) {
                l = map.get(groupSizes[i]);
            } else {
                l = new ArrayList<>();
            }
            l.add(i);
            map.put(groupSizes[i], l);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            List<Integer> people = e.getValue();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < people.size(); i++) {
                if (list.size() == e.getKey()) {
                    ans.add(list);
                    list.clear();
                }
                list.add(people.get(i));
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[5],[0,1,2],[3,4,6]]
        System.out.println(s.groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3}));
        // [[1],[0,5],[2,3,4]]
        System.out.println(s.groupThePeople(new int[]{2,1,3,3,3,2}));
    }

}
