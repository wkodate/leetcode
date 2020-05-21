package com.wkodate.leetcode.LC1227_CountSquareSubmatricesWithAllOnes;

public class Solution {

    public int countSquares(int[][] matrix) {
        int ans = 0;
        int side = 1;
        while (side <= Math.min(matrix.length, matrix[0].length)) {
            for (int i = 0; i < matrix.length - side + 1; i++) {
                for (int j = 0; j < matrix[0].length - side + 1; j++) {
                    boolean square = true;
                    for (int k = i; k < i + side; k++) {
                        for (int l = j; l < j + side; l++) {
                            if (matrix[k][l] != 1) {
                                square = false;
                                break;
                            }
                        }
                        if (!square) {
                            break;
                        }
                    }
                    if (square) {
                        ans++;
                    }
                }
            }
            side++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countSquares(new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } }));
        System.out.println(s.countSquares(new int[][] { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } }));
    }

}
