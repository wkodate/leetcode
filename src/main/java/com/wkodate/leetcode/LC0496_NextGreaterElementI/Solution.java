package com.wkodate.leetcode.LC0496_NextGreaterElementI;

import java.util.Arrays;

public class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = -1;
        }
        for (int i = 0; i < nums1.length; i++) {
            boolean found = false;
            for (int j = 0; j < nums2.length; j++) {
                if (found && nums1[i] < nums2[j]) {
                    ans[i] = nums2[j];
                    break;
                }
                if (nums1[i] == nums2[j]) {
                    found = true;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [-1,3,-1]
        System.out.println(Arrays.toString(s.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        // [3,-1]
        System.out.println(Arrays.toString(s.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
        // [-1]
        System.out.println(Arrays.toString(s.nextGreaterElement(new int[]{0}, new int[]{0})));
    }

}
