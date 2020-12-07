package com.wkodate.leetcode.LC0059_SpiralMatrixII;

import java.util.Arrays;

public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int count = 1;
        int row = 0;
        int col = 0;
        while (count <= n * n) {
            while (col <= ans[0].length - 1 && !visited[row][col]) {
                ans[row][col] = count++;
                visited[row][col++] = true;
            }
            row++;
            col--;
            while (row <= ans.length - 1 && !visited[row][col]) {
                ans[row][col] = count++;
                visited[row++][col] = true;
            }
            row--;
            col--;
            while (col >= 0 && !visited[row][col]) {
                ans[row][col] = count++;
                visited[row][col--] = true;
            }
            row--;
            col++;
            while (row >= 0 && !visited[row][col]) {
                ans[row][col] = count++;
                visited[row--][col] = true;
            }
            row++;
            col++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,2,3],[8,9,4],[7,6,5]]
        System.out.println(Arrays.deepToString(s.generateMatrix(3)));
        // [[1]]
        System.out.println(Arrays.deepToString(s.generateMatrix(1)));
    }

}
