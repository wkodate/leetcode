package com.wkodate.leetcode.LC0045_JumpGameII;

public class Solution {

    public int jump(int[] nums) {
        int curr = -1;
        int next = 0;
        int ans = 0;
        for (int i = 0; next < nums.length - 1; i++) {
            if (i > curr) {
                ans++;
                curr = next;
            }
            next = Math.max(next, nums[i] + i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.jump(new int[] { 2, 3, 1, 1, 4 }));
        // 2
        System.out.println(s.jump(new int[] { 2, 3, 0, 1, 4 }));
    }

}
