package com.wkodate.leetcode.LC1646_GetMaximumInGeneratedArray;

public class Solution {

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;
        for (int i = 1; 2 * i <= n; i++) {
            nums[2 * i] = nums[i];
            max = Math.max(nums[2 * i], max);
            if (2 * i + 1 <= n) {
                nums[2 * i + 1] = nums[i] + nums[i + 1];
                max = Math.max(nums[2 * i + 1], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.getMaximumGenerated(0));
        // 1
        System.out.println(s.getMaximumGenerated(1));
        // 1
        System.out.println(s.getMaximumGenerated(2));
        // 2
        System.out.println(s.getMaximumGenerated(3));
        // 3
        System.out.println(s.getMaximumGenerated(7));
    }

}
