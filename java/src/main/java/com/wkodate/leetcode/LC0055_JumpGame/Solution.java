package com.wkodate.leetcode.LC0055_JumpGame;

public class Solution {

    public boolean canJump(int[] nums) {
        boolean[] canJumpPos = new boolean[nums.length];
        canJumpPos[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (!canJumpPos[i]) {
                continue;
            }
            int num = nums[i];
            for (int j = i; j <= i + num; j++) {
                if (j >= nums.length) {
                    break;
                }
                canJumpPos[j] = true;
            }
        }
        return canJumpPos[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.canJump(new int[]{2, 3, 1, 1, 4}));
        // false
        System.out.println(s.canJump(new int[]{3, 2, 1, 0, 4}));
    }

}
