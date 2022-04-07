package com.wkodate.leetcode.LC0200_NumberOfIslands;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    private int[] dx = new int[]{1, 0, -1, 0};
    private int[] dy = new int[]{0, 1, 0, -1};
    private boolean[][] visited;
    private Deque<int[]> queue;

    private void bfs(char[][] grid) {
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int x = p[0] + dx[i];
                int y = p[1] + dy[i];
                if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length
                        || grid[x][y] == '0' || visited[x][y]) {
                    continue;
                }
                queue.offer(new int[]{x, y});
                visited[x][y] = true;
            }
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid.length == 0) {
            return count;
        }
        visited = new boolean[grid.length][grid[0].length];
        queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0' || visited[i][j]) {
                    continue;
                }
                queue.offer(new int[]{i, j});
                visited[i][j] = true;
                bfs(grid);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        char[][] grid1 = new char[][]{{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}};
        System.out.println(s.numIslands(grid1));
        // 3
        char[][] grid2 = new char[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        System.out.println(s.numIslands(grid2));
        // 0
        char[][] grid3 = new char[][]{{}};
        System.out.println(s.numIslands(grid3));
    }

}
