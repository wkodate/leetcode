package com.wkodate.leetcode.LC1572_MatrixDiagonalSum;

public class Solution {

    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            sum += mat[i][mat.length - 1 - i];
        }
        if (mat.length % 2 != 0) {
            sum -= mat[mat.length / 2][mat.length / 2];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 25
        System.out.println(s.diagonalSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        // 8
        System.out.println(s.diagonalSum(new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}}));
        // 5
        System.out.println(s.diagonalSum(new int[][]{{5}}));
    }

}
