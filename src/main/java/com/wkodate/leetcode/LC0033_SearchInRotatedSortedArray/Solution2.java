package com.wkodate.leetcode.LC0033_SearchInRotatedSortedArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        int left = -1;
        int right = nums.length;
        int mid;
        while (right - left > 1) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (right >= nums.length || nums[right] != target) {
            return -1;
        }
        return map.get(nums[right]);
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 4
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        // -1
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        // -1
        System.out.println(s.search(new int[]{}, 5));
        // -1
        System.out.println(s.search(new int[]{1}, 2));
    }

}
