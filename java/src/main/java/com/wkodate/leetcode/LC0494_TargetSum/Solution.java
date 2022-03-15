package com.wkodate.leetcode.LC0494_TargetSum;

public class Solution {

    int count = 0;

    public void dfs(int[] nums, int depth, int sum, int S) {
        if (depth == nums.length) {
            if (sum == S) {
                count++;
            }
        } else {
            dfs(nums, depth + 1, sum + nums[depth], S);
            dfs(nums, depth + 1, sum - nums[depth], S);
        }
    }

    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, 0, S);
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(s.findTargetSumWays(new int[]{2, 1, 1, 1, 1}, 4));
    }

}
