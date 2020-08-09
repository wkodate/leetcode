package com.wkodate.leetcode.LC0994_RottingOranges;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {

    class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean hasFrechOrange(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public int orangesRotting(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        int cnt = -1;
        boolean[][] visited = new boolean[h][w];
        Deque<Pos> queue = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 2) {
                    visited[i][j] = true;
                    queue.add(new Pos(i, j));
                }
            }
        }
        if (queue.isEmpty()) {
            if (hasFrechOrange(grid)) {
                return -1;
            }
            return 0;
        }
        while (!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Pos p = queue.poll();
                int[][] dxdy = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
                for (int l = 0; l < dxdy.length; l++) {
                    int x = p.x + dxdy[l][0];
                    int y = p.y + dxdy[l][1];
                    if (x < 0 || x >= h || y < 0 || y >= w || visited[x][y] || grid[x][y] != 1) {
                        continue;
                    }
                    visited[x][y] = true;
                    grid[x][y] = 2;
                    queue.add(new Pos(x, y));
                }
            }
        }
        if (hasFrechOrange(grid)) {
            return -1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 4
        int[][] rows = new int[3][3];
        rows[0] = new int[] { 2, 1, 1 };
        rows[1] = new int[] { 1, 1, 0 };
        rows[2] = new int[] { 0, 1, 1 };
        System.out.println(s.orangesRotting(rows));
        // -1
        int[][] rows2 = new int[3][3];
        rows2[0] = new int[] { 2, 1, 1 };
        rows2[1] = new int[] { 0, 1, 1 };
        rows2[2] = new int[] { 1, 0, 1 };
        System.out.println(s.orangesRotting(rows2));
        // 0
        int[][] rows3 = new int[1][1];
        rows3[0] = new int[] { 0, 2 };
        System.out.println(s.orangesRotting(rows3));
        // 0
        int[][] rows4 = new int[1][1];
        rows4[0] = new int[] { 0 };
        System.out.println(s.orangesRotting(rows4));
        // -1
        int[][] rows5 = new int[1][1];
        rows5[0] = new int[] { 1 };
        System.out.println(s.orangesRotting(rows5));
    }

}
