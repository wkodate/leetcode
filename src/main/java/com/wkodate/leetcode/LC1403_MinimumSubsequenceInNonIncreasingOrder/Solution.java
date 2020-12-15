package com.wkodate.leetcode.LC1403_MinimumSubsequenceInNonIncreasingOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
        }
        int left = 0;
        int i = 0;
        while (i < nums.length) {
            left += nums[i];
            right -= nums[i];
            if (left >= right) {
                break;
            }
            i++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int j = nums.length - 1; j >= i; j--) {
            ans.add(nums[j]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [10,9]
        System.out.println(s.minSubsequence(new int[] { 4, 3, 10, 9, 8 }));
        // [7,7,6]
        System.out.println(s.minSubsequence(new int[] { 4, 4, 7, 6, 7 }));
        // [6]
        System.out.println(s.minSubsequence(new int[] { 6 }));
    }

}
