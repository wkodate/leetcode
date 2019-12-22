package com.wkodate.leetcode.LC0599_MinimumIndexSumOfTwoLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }
        int minSum = Integer.MAX_VALUE;
        List<String> minKeys = new ArrayList<>();
        for (Map.Entry<String, Integer> e : map1.entrySet()) {
            String key = e.getKey();
            if (map2.containsKey(key)) {
                int sum = e.getValue() + map2.get(key);
                if (sum == minSum) {
                    minKeys.add(key);
                } else if (sum < minSum) {
                    minSum = sum;
                    minKeys = new ArrayList<>();
                    minKeys.add(key);
                }
            }
        }
        String[] minKeysArr = new String[minKeys.size()];
        for (int i = 0; i < minKeysArr.length; i++) {
            minKeysArr[i] = minKeys.get(i);
        }
        return minKeysArr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        System.out.println(Arrays.toString(s.findRestaurant(list1, list2)));
    }

}
