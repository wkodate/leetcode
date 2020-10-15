package com.wkodate.leetcode.LC1460_MakeTwoArraysEqualByReversingSubArrays;

import java.util.Arrays;

public class Solution {

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
        // true
        System.out.println(s.canBeEqual(new int[]{7}, new int[]{7}));
        // true
        System.out.println(s.canBeEqual(new int[]{1, 12}, new int[]{12, 1}));
        // false
        System.out.println(s.canBeEqual(new int[]{3, 7, 9}, new int[]{3, 7, 11}));
        // true
        System.out.println(s.canBeEqual(new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1}));
    }

}
