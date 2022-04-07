package com.wkodate.leetcode.ThirtyDayLeetCodingChallenge.CountingElements;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i] + 1)) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.countElements(new int[]{1, 2, 3}));
        // 0
        System.out.println(s.countElements(new int[]{1, 1, 3, 3, 5, 5, 7, 7}));
        // 3
        System.out.println(s.countElements(new int[]{1, 3, 2, 3, 5, 0}));
        // 2
        System.out.println(s.countElements(new int[]{1, 1, 2, 2}));
    }
}
