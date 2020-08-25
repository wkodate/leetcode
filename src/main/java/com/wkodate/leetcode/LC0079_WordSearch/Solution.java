package com.wkodate.leetcode.LC0079_WordSearch;

public class Solution {

    private static final int[][] DXDY = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    private char[][] board;
    private String word;

    private boolean dfs(int x, int y, int idx, boolean[][] visited) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length
            || board[x][y] != word.charAt(idx) || visited[x][y] || idx >= word.length()) {
            return false;
        }
        if (idx == word.length() - 1 && board[x][y] == word.charAt(idx)) {
            return true;
        }
        idx++;
        boolean[][] v = new boolean[visited.length][visited[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (visited[i][j]) {
                    v[i][j] = true;
                }
            }
        }
        v[x][y] = true;
        return dfs(x + DXDY[0][0], y + DXDY[0][1], idx, v)
               || dfs(x + DXDY[1][0], y + DXDY[1][1], idx, v)
               || dfs(x + DXDY[2][0], y + DXDY[2][1], idx, v)
               || dfs(x + DXDY[3][0], y + DXDY[3][1], idx, v);
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != word.charAt(0)) {
                    continue;
                }
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (dfs(i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        // true
        System.out.println(s.exist(board, "ABCCED"));
        // true
        System.out.println(s.exist(board, "SEE"));
        // false
        System.out.println(s.exist(board, "ABCB"));
        char[][] board2 = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'E', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        // true
        System.out.println(s.exist(board2, "ABCESEEEFS"));
    }

}
