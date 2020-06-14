package com.wkodate.leetcode.LC0368_LargestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private List<Integer> res;
    private int[] subset;

    private void dfs(int[] nums, int index, List<Integer> curr, int prev) {
        if (curr.size() > res.size()) {
            res = new ArrayList<>(curr);
        }
        for (int i = index; i < nums.length; i++) {
            if (curr.size() > subset[i] && nums[i] % prev == 0) {
                subset[i] = curr.size();
                curr.add(nums[i]);
                dfs(nums, i + 1, curr, nums[i]);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        subset = new int[nums.length];
        Arrays.fill(subset, -1);
        res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), 1);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2]
        System.out.println(s.largestDivisibleSubset(new int[] { 1, 2, 3 }));
        // [1,2,4,8]
        System.out.println(s.largestDivisibleSubset(new int[] { 1, 2, 4, 8 }));
    }

}
