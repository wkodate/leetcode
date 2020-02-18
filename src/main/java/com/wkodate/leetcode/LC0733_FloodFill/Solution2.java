package com.wkodate.leetcode.LC0733_FloodFill;

import java.util.Arrays;

public class Solution2 {

    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] != color) {
            return;
        }
        image[r][c] = newColor;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        for (int i = 0; i < dx.length; i++) {
            int x = r + dx[i];
            int y = c + dy[i];
            if (x >= 0 && x <= image.length - 1 && y >= 0 && y <= image[0].length - 1
                    && image[x][y] == color) {
                dfs(image, x, y, color, newColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        int color = image[sr][sc];
        dfs(image, sr, sc, color, newColor);
        return image;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
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
