package com.wkodate.leetcode.LC0977_SquaresOfASortedArray;

import java.util.Arrays;

public class Solution {

    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = (int) Math.pow(A[i], 2);
        }
        Arrays.sort(A);
        return A;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,1,9,16,100]
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        // [4,9,9,49,121]
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }

}
