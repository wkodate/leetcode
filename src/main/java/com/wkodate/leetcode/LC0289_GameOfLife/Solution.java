package com.wkodate.leetcode.LC0289_GameOfLife;

import java.util.Arrays;

public class Solution {

    public void gameOfLife(int[][] board) {
        int[][] updated = new int[board.length][board[0].length];
        int[][] dxdyList = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int cnt = 0;
                for (int[] dxdy : dxdyList) {
                    int row = i + dxdy[0];
                    int col = j + dxdy[1];
                    if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1) {
                        continue;
                    }
                    if (board[row][col] == 1) {
                        cnt++;
                    }
                }
                if ((board[i][j] == 1 && (cnt == 2 || cnt == 3))
                        || (board[i][j] == 0 && cnt == 3)) {
                    updated[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = updated[i][j];
            }
        }
        System.out.println(Arrays.deepToString(board));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
        s.gameOfLife(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}});
        // [[1,1],[1,1]]
        s.gameOfLife(new int[][]{{1, 1}, {1, 0}});
    }

}
