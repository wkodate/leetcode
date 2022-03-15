package com.wkodate.leetcode.LC1091_ShortestPathInBinaryMatrix;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        if (grid.length == 1 && grid[0].length == 1) {
            return 1;
        }
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        queue.add(new int[] { 0, 0 });
        int cnt = 1;
        int[][] dxdy = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
        while (!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int j = 0; j < dxdy.length; j++) {
                    int r = pos[0] + dxdy[j][0];
                    int c = pos[1] + dxdy[j][1];
                    if (r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[0].length - 1
                        && !visited[r][c] && grid[r][c] == 0) {
                        if (r == grid.length - 1 && c == grid[0].length - 1) {
                            return cnt;
                        }
                        visited[r][c] = true;
                        queue.add(new int[] { r, c });
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.shortestPathBinaryMatrix(new int[][] { { 0, 1 }, { 1, 0 } }));
        // 4
        System.out.println(s.shortestPathBinaryMatrix(new int[][] {
                { 0, 0, 0 },
                { 1, 1, 0 },
                { 1, 1, 0 }
        }));
        // -1
        System.out.println(s.shortestPathBinaryMatrix(new int[][] {
                { 1, 0, 0 },
                { 1, 1, 0 },
                { 1, 1, 0 }
        }));
        // 1
        System.out.println(s.shortestPathBinaryMatrix(new int[][] { { 0 } }));
        // 10
        System.out.println(s.shortestPathBinaryMatrix(new int[][] {
                { 0, 0, 1, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 0, 1 },
                { 0, 0, 1, 0, 1, 0, 0 },
                { 0, 0, 0, 1, 1, 1, 0 },
                { 1, 0, 0, 1, 1, 0, 0 },
                { 1, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 1, 0, 0, 0, 0 }
        }));
    }

}
