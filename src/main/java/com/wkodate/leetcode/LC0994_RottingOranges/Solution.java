package com.wkodate.leetcode.LC0994_RottingOranges;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        Deque<Pos> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pos(i, j));
                }
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pos pos = queue.remove();
                int x = pos.x;
                int y = pos.y;
                int x1 = pos.x + 1;
                int x2 = pos.x - 1;
                int y1 = pos.y + 1;
                int y2 = pos.y - 1;
                if (x1 < grid.length && grid[x1][y] == 1) {
                    grid[x1][y] = 2;
                    queue.add(new Pos(x1, y));
                }
                if (x2 >= 0 && grid[x2][y] == 1) {
                    grid[x2][y] = 2;
                    queue.add(new Pos(x2, y));
                }
                if (y1 < grid[0].length && grid[x][y1] == 1) {
                    grid[x][y1] = 2;
                    queue.add(new Pos(x, y1));
                }
                if (y2 >= 0 && grid[x][y2] == 1) {
                    grid[x][y2] = 2;
                    queue.add(new Pos(x, y2));
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return Math.max(0, count - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        int[][] rows = new int[3][3];
        rows[0] = new int[]{2, 1, 1};
        rows[1] = new int[]{1, 1, 0};
        rows[2] = new int[]{0, 1, 1};
        System.out.println(s.orangesRotting(rows));
        // -1
        int[][] rows2 = new int[3][3];
        rows2[0] = new int[]{2, 1, 1};
        rows2[1] = new int[]{0, 1, 1};
        rows2[2] = new int[]{1, 0, 1};
        System.out.println(s.orangesRotting(rows2));
        // 0
        int[][] rows3 = new int[1][1];
        rows3[0] = new int[]{0, 2};
        System.out.println(s.orangesRotting(rows3));
        // 0
        int[][] rows4 = new int[1][1];
        rows4[0] = new int[]{0};
        System.out.println(s.orangesRotting(rows4));
    }

}
