package com.wkodate.leetcode.LC0054_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) {
            return ans;
        }
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        boolean[][] seen = new boolean[rLen][cLen];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int r = 0;
        int c = 0;
        int direction = 0;
        for (int i = 0; i < rLen * cLen; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[direction];
            int cc = c + dc[direction];
            if (0 <= cr && cr < rLen && 0 <= cc && cc < cLen
                    && !seen[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                direction = (direction + 1) % 4;
                r += dr[direction];
                c += dc[direction];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2,3,6,9,8,7,4,5]
        System.out.println(s.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        // [1,2,3,4,8,12,11,10,9,5,6,7]
        System.out.println(s.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }

}
