package com.wkodate.leetcode.LC0961_NRepeatedElementInSize2NArray;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (!set.contains(A[i])) {
            set.add(A[i++]);
        }
        return A[i];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.repeatedNTimes(new int[]{1, 2, 3, 3}));
        // 2
        System.out.println(s.repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        // 5
        System.out.println(s.repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }

}
