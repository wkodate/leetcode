package com.wkodate.leetcode.LC0645_SetMismatch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                ans[0] = num;
            }
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,3]
        System.out.println(Arrays.toString(s.findErrorNums(new int[]{1, 2, 2, 4})));
    }

}
