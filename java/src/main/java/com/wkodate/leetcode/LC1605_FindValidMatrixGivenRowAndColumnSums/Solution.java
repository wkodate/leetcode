package com.wkodate.leetcode.LC1605_FindValidMatrixGivenRowAndColumnSums;

import java.util.Arrays;

public class Solution {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                ans[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= ans[i][j];
                colSum[j] -= ans[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[3,0],[1,7]]
        System.out.println(Arrays.deepToString(s.restoreMatrix(new int[]{3, 8}, new int[]{4, 7})));
        // [[0,5,0],[6,1,0],[2,0,8]]
        System.out.println(Arrays.deepToString(s.restoreMatrix(new int[]{5, 7, 10}, new int[]{8, 6, 8})));
        // [[0,9,5],[6,0,3]]
        System.out.println(Arrays.deepToString(s.restoreMatrix(new int[]{14, 9}, new int[]{6, 9, 8})));
        // [[1],[0]]
        System.out.println(Arrays.deepToString(s.restoreMatrix(new int[]{1,0}, new int[]{1})));
        // [[0]]
        System.out.println(Arrays.deepToString(s.restoreMatrix(new int[]{0}, new int[]{0})));
    }

}
