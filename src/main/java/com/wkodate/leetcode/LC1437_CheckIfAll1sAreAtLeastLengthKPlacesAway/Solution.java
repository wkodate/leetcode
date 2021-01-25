package com.wkodate.leetcode.LC1437_CheckIfAll1sAreAtLeastLengthKPlacesAway;

public class Solution {

    public boolean kLengthApart(int[] nums, int k) {
        int i = 0;
        while (i < nums.length && nums[i] == 0) {
            i++;
        }
        int cnt = 0;
        i++;
        while (i < nums.length) {
            if (nums[i] == 1) {
                if (cnt < k) {
                    return false;
                } else {
                    cnt = 0;
                }
            } else {
                cnt++;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.kLengthApart(new int[] { 1, 0, 1 }, 2));
        // true
        System.out.println(s.kLengthApart(new int[] { 1, 0, 0, 0, 1, 0, 0, 1 }, 2));
        // false
        System.out.println(s.kLengthApart(new int[] { 1, 0, 0, 1, 0, 1 }, 2));
        // true
        System.out.println(s.kLengthApart(new int[] { 1, 1, 1, 1, 1 }, 0));
        // true
        System.out.println(s.kLengthApart(new int[] { 0, 1, 0, 1 }, 1));

    }

}
