package com.wkodate.leetcode.LC0908_SmallestRangeI;

import java.util.Arrays;

public class Solution {

    public int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        return Math.max(A[A.length - 1] - A[0] - 2 * K, 0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.smallestRangeI(new int[]{1}, 0));
        // 6
        System.out.println(s.smallestRangeI(new int[]{0, 10}, 2));
        // 0
        System.out.println(s.smallestRangeI(new int[]{1, 3, 6}, 3));
    }

}
