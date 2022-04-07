package com.wkodate.leetcode.LC0080_RemoveDuplicatesFromSortedArrayII;

import java.util.Arrays;

public class Solution {

    public int removeDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean dup = false;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    break;
                }
                if (!dup) {
                    dup = true;
                    continue;
                }
                boolean same = true;
                for (int k = j; k < nums.length - 1; k++) {
                    if (nums[k] != nums[k + 1]) {
                        same = false;
                    }
                    int tmp = nums[k + 1];
                    nums[k + 1] = nums[k];
                    nums[k] = tmp;
                }
                if (same) {
                    break;
                }
                j--;
            }
        }
        int len = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                break;
            }
            len++;
            if (i < nums.length - 2 && nums[i] == nums[i + 2]) {
                break;
            }
        }
        System.out.println(Arrays.toString(nums));
        return len;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2, nums = [1,1]
        System.out.println(s.removeDuplicates(new int[]{1, 1, 1}));
        // 4, nums = [0,0,1,1]
        System.out.println(s.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1}));
        // 7, nums = [0,0,1,1,2,3,3]
        System.out.println(s.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
        // 5, nums = [1,1,2,2,3]
        System.out.println(s.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }

}
