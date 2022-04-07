package com.wkodate.leetcode.LC1848_MinimumDistanceToTheTargetElement;

public class Solution {

    public int getMinDistance(int[] nums, int target, int start) {
        int dis = 0;
        for (int i = 0; i < Math.max(start, nums.length - start + 1); i++) {
            int idx1 = start + i;
            int idx2 = start - i;
            if ((idx1 >= 0 && idx1 <= nums.length - 1 && nums[idx1] == target)
                || (idx2 >= 0 && idx2 <= nums.length - 1 && nums[idx2] == target)) {
                return dis;
            }
            dis++;
        }
        return Math.max(start, Math.abs(nums.length - start + 1));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.getMinDistance(new int[] { 1, 2, 3, 4, 5 }, 5, 3));
        // 0
        System.out.println(s.getMinDistance(new int[] { 1 }, 1, 0));
        // 0
        System.out.println(s.getMinDistance(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 1, 0));
    }

}
