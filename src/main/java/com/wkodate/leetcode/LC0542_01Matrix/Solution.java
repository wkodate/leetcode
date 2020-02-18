package com.wkodate.leetcode.LC0542_01Matrix;

import java.util.Arrays;

public class Solution {

    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    private void dfs(int[][] matrix, int x, int y, int val) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] < val) {
            return;
        }
        matrix[x][y] = val;
        for (int i = 0; i < dx.length; i++) {
            int row = x + dx[i];
            int col = y + dy[i];
            dfs(matrix, row, col, matrix[x][y] + 1);
        }
    }

    private boolean hasNeiborZero(int x, int y, int[][] matrix) {
        for (int i = 0; i < dx.length; i++) {
            int row = x + dx[i];
            int col = y + dy[i];
            if (row >= 0 && row <= matrix.length -1&& col >= 0 && col <= matrix[0].length-1
                    && matrix[row][col] == 0) {
                return true;
            }
        }
        return false;
    }

    public int[][] updateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && !hasNeiborZero(i, j, matrix)) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    dfs(matrix, i, j, 1);
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix1 = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(s.updateMatrix(matrix1)));
        int[][] matrix2 = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(s.updateMatrix(matrix2)));
        int[][] matrix3 = new int[][]{{0, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(s.updateMatrix(matrix3)));
    }

}
