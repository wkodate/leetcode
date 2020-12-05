package com.wkodate.leetcode.LC1314_MatrixBlockSum;

import java.util.Arrays;

public class Solution {

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] ans = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                for (int k = Math.max(i - K, 0); k < Math.min(i + K + 1, mat.length); k++) {
                    for (int l = Math.max(j - K, 0); l < Math.min(j + K + 1, mat[0].length); l++) {
                        ans[i][j] += mat[k][l];
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[12,21,16],[27,45,33],[24,39,28]]
        System.out.println(Arrays.deepToString(
                s.matrixBlockSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 1)));
        // [[45,45,45],[45,45,45],[45,45,45]]
        System.out.println(Arrays.deepToString(
                s.matrixBlockSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 2)));
    }

}
