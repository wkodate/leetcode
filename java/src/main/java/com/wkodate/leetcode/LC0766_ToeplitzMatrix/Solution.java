package com.wkodate.leetcode.LC0766_ToeplitzMatrix;

public class Solution {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        for (int i = 0; i < rowLen + colLen - 1; i++) {
            int row = Math.max(rowLen - i - 1, 0);
            int column = Math.max(i - rowLen + 1, 0);
            while ((row + 1) < rowLen && (column + 1) < colLen) {
                if (matrix[row][column] != matrix[row + 1][column + 1]) {
                    return false;
                }
                row++;
                column++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrics1 = new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(s.isToeplitzMatrix(matrics1));
        int[][] matrics2 = new int[][]{{1, 2}, {2, 2}};
        System.out.println(s.isToeplitzMatrix(matrics2));
    }

}
