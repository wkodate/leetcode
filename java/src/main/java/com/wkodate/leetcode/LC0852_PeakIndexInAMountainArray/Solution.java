package com.wkodate.leetcode.LC0852_PeakIndexInAMountainArray;

public class Solution {

    public int peakIndexInMountainArray(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] >= A[i + 1]) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.peakIndexInMountainArray(new int[]{0, 1, 0}));
        // 1
        System.out.println(s.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
    }

}
