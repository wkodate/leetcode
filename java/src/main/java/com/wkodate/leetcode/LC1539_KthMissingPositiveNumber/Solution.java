package com.wkodate.leetcode.LC1539_KthMissingPositiveNumber;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int findKthPositive(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int num = 0;
        int cnt = 0;
        while(cnt < k) {
            num++;
            if (!set.contains(num)) {
                cnt++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 9
        System.out.println(s.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        // 6
        System.out.println(s.findKthPositive(new int[]{1, 2, 3, 4}, 2));
    }

}
