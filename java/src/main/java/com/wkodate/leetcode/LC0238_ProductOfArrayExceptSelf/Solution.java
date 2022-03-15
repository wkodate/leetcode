package com.wkodate.leetcode.LC0238_ProductOfArrayExceptSelf;

import java.util.Arrays;

public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int p = 1;
        int zeroIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroIdx != -1) {
                    Arrays.fill(ans, 0);
                    return ans;
                }
                zeroIdx = i;
                continue;
            }
            p *= nums[i];
        }
        if (zeroIdx != -1) {
            Arrays.fill(ans, 0);
            ans[zeroIdx] = p;
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = p / nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [24,12,8,6]
        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{1, 2, 3, 4})));
        // [0, 0]
        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{0, 0})));
        // [0, 1]
        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{1, 0})));
    }

}
