package com.wkodate.leetcode.LC1122_RelativeSortArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> arr2RelIdx = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            arr2RelIdx.put(arr2[i], i);
        }
        int[] freq = new int[arr2.length];
        List<Integer> rest = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            int num = arr1[i];
            if (!arr2RelIdx.containsKey(num)) {
                rest.add(num);
                continue;
            }
            freq[arr2RelIdx.get(num)]++;
        }
        int[] ans = new int[arr1.length];
        int idx = 0;
        for (int i = 0; i < arr2.length; i++) {
            int num = arr2[i];
            for (int j = 0; j < freq[i]; j++) {
                ans[idx++] = num;
            }
        }
        Collections.sort(rest);
        for (int i = 0; i < rest.size(); i++) {
            ans[idx++] = rest.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,2,2,1,4,3,3,9,6,7,19]
        System.out.println(Arrays.toString(s.relativeSortArray(
                new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
                new int[]{2, 1, 4, 3, 9, 6}
        )));
    }

}
