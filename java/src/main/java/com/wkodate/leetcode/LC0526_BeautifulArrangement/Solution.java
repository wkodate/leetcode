package com.wkodate.leetcode.LC0526_BeautifulArrangement;

public class Solution {

    private int count;

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    private void permute(int[] nums, int len) {
        if (len == nums.length) {
            count++;
        }
        for (int i = len; i < nums.length; i++) {
            swap(nums, i, len);
            if (nums[len] % (len + 1) == 0 || (len + 1) % nums[len] == 0) {
                permute(nums, len + 1);
            }
            swap(nums, i, len);
        }
    }

    public int countArrangement(int n) {
        count = 0;
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        permute(nums, 0);
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.countArrangement(1));
        // 2
        System.out.println(s.countArrangement(2));
        // 3
        System.out.println(s.countArrangement(3));
        // 8
        System.out.println(s.countArrangement(4));
        // 10
        System.out.println(s.countArrangement(5));
    }

}
