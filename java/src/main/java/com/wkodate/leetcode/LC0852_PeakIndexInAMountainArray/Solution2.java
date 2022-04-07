package com.wkodate.leetcode.LC0852_PeakIndexInAMountainArray;

public class Solution2 {

    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (A[middle] < A[middle + 1]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 1
        System.out.println(s.peakIndexInMountainArray(new int[]{0, 1, 0}));
        // 1
        System.out.println(s.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
    }

}
