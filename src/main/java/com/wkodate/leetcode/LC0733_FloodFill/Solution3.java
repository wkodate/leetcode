package com.wkodate.leetcode.LC0733_FloodFill;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution3 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(sr, sc));
        final int[][] DXDY = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point p = queue.poll();
                int posx = p.x;
                int posy = p.y;
                for (int j = 0; j < DXDY.length; j++) {
                    int x = posx + DXDY[j][0];
                    int y = posy + DXDY[j][1];
                    if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != color
                        || visited[x][y]) {
                        continue;
                    }
                    image[x][y] = newColor;
                    visited[x][y] = true;
                    queue.add(new Point(x, y));
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        // [[0,0,1],[0,1,1]
        System.out.println(
                Arrays.deepToString(
                        s.floodFill(new int[][] { { 0, 0, 1 }, { 0, 1, 1 } }, 1, 1, 1)));
        // [[2,2,2],[2,2,0],[2,0,1]]
        System.out.println(
                Arrays.deepToString(
                        s.floodFill(new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }, 1, 1, 2)));
        // [[0,0,0],[0,2,0]]
        System.out.println(
                Arrays.deepToString(
                        s.floodFill(new int[][] { { 0, 0, 0 }, { 0, 1, 0 } }, 1, 1, 2)));
        // [[0,0,0],[0,1,1]]
        System.out.println(
                Arrays.deepToString(
                        s.floodFill(new int[][] { { 0, 0, 0 }, { 0, 1, 1 } }, 1, 1, 1)));
    }

}
