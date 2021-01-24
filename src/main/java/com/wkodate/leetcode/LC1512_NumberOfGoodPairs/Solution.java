package com.wkodate.leetcode.LC1512_NumberOfGoodPairs;

public class Solution {

    public int numIdenticalPairs(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.numIdenticalPairs(new int[] { 1, 2, 3, 1, 1, 3 }));
        // 6
        System.out.println(s.numIdenticalPairs(new int[] { 1, 1, 1, 1 }));
        // 0
        System.out.println(s.numIdenticalPairs(new int[] { 1, 2, 3 }));
    }

}
