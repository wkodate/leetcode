package com.wkodate.leetcode.LC1356_SortIntegersByTheNumberOf1Bits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            int bitCount = Integer.bitCount(arr[i]);
            List<Integer> list;
            if (map.containsKey(bitCount)) {
                list = map.get(bitCount);
            } else {
                list = new ArrayList<>();
            }
            list.add(arr[i]);
            map.put(bitCount, list);
        }
        int[] ans = new int[arr.length];
        int i = 0;
        for (List<Integer> v : map.values()) {
            Collections.sort(v);
            for (int j = 0; j < v.size(); j++) {
                ans[i++] = v.get(j);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,1,2,4,8,3,5,6,7]
        System.out.println(Arrays.toString(s.sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
        // [1,2,4,8,16,32,64,128,256,512,1024]
        System.out.println(Arrays.toString(s.sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));
        // [10000,10000]
        System.out.println(Arrays.toString(s.sortByBits(new int[]{10000, 10000})));
        // [2,3,5,17,7,11,13,19]
        System.out.println(Arrays.toString(s.sortByBits(new int[]{2, 3, 5, 7, 11, 13, 17, 19})));
        // [10,100,10000,1000]
        System.out.println(Arrays.toString(s.sortByBits(new int[]{10, 100, 1000, 10000})));
    }

}
