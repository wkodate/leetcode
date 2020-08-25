package com.wkodate.leetcode.LC0015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                } else if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //   [0,0,0,0,0]
        System.out.println(s.threeSum(new int[] { 0, 0, 0, 0, 0 }));
        //   [-1, 0, 1],[-1, -1, 2]
        System.out.println(s.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }

}
