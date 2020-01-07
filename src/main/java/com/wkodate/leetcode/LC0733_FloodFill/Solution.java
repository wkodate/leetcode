package com.wkodate.leetcode.LC0733_FloodFill;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        Deque<Pos> queue = new ArrayDeque<>();
        Pos start = new Pos(sr, sc);
        int c = image[sr][sc];
        queue.add(start);
        while (!queue.isEmpty()) {
            Pos target = queue.remove();
            int x = target.x;
            int y = target.y;
            image[x][y] = newColor;
            if (x <= image.length - 2 && image[x + 1][y] == c) {
                queue.add(new Pos(x + 1, y));
            }
            if (x >= 1 && image[x - 1][y] == c) {
                queue.add(new Pos(x - 1, y));
            }
            if (y <= image[0].length - 2 && image[x][y + 1] == c) {
                queue.add(new Pos(x, y + 1));
            }
            if (y >= 1 && image[x][y - 1] == c) {
                queue.add(new Pos(x, y - 1));
            }
        }
        return image;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[2,2,2],[2,2,0],[2,0,1]]
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] ans = s.floodFill(image, 1, 1, 2);
        for (int[] rows : ans) {
            System.out.println(Arrays.toString(rows));
        }
        // [[2,2,2],[2,2,2]]
        int[][] image2 = new int[][]{{0, 0, 0}, {0, 0, 0}};
        int[][] ans2 = s.floodFill(image2, 0, 0, 2);
        for (int[] rows : ans2) {
            System.out.println(Arrays.toString(rows));
        }
        // [[0,0,0],[0,1,1]]
        int[][] image3 = new int[][]{{0, 0, 0}, {0, 1, 1}};
        int[][] ans3 = s.floodFill(image3, 1, 1, 1);
        for (int[] rows : ans3) {
            System.out.println(Arrays.toString(rows));
        }
    }

}
