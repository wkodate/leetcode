package com.wkodate.leetcode.LC0976_LargestPerimeterTriangle;

import java.util.Arrays;

public class Solution {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.largestPerimeter(new int[]{2, 1, 2}));
        // 0
        System.out.println(s.largestPerimeter(new int[]{1, 2, 1}));
        // 10
        System.out.println(s.largestPerimeter(new int[]{3, 2, 3, 4}));
        // 8
        System.out.println(s.largestPerimeter(new int[]{3, 6, 2, 3}));
    }

}
