package com.wkodate.leetcode.LC0130_SurroundedRegions;

import java.util.Arrays;

public class Solution {

    private void dfs(int r, int c, boolean[][] visited, char[][] board) {
        int[][] dxdy = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int i = 0; i < dxdy.length; i++) {
            int row = r + dxdy[i][0];
            int col = c + dxdy[i][1];
            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || visited[row][col]) {
                continue;
            }
            visited[row][col] = true;
            dfs(row, col, visited, board);
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    visited[i][j] = true;
                } else {
                    visited[i][j] = false;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i > 0 && i < board.length - 1 && j > 0 && j < board[0].length - 1
                    || board[i][j] == 'X' || visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                dfs(i, j, visited, board);
            }
        }
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
        System.out.println(Arrays.deepToString(board));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solve(new char[][] {
                { 'X', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'O' },
                { 'X', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'X' },
                { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X' },
                { 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X' },
                { 'O', 'O', 'X', 'X', 'O', 'X', 'X', 'O', 'O', 'O' },
                { 'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O' },
                { 'X', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'X', 'O' },
                { 'X', 'X', 'O', 'X', 'X', 'O', 'X', 'O', 'O', 'X' },
                { 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O' },
                { 'X', 'X', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O' }
        });
        s.solve(new char[][] {
                { 'X', 'X', 'X' },
                { 'X', 'O', 'X' },
                { 'X', 'X', 'X' }
        });
        s.solve(new char[][] {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' }
        });
    }

}
