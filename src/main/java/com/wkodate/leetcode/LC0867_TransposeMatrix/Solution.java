package com.wkodate.leetcode.LC0867_TransposeMatrix;

import java.util.Arrays;

public class Solution {

    public int[][] transpose(int[][] A) {
        int[][] transpose = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                transpose[j][i] = A[i][j];
            }
        }
        return transpose;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println(Arrays.deepToString(s.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}})));
    }

}
