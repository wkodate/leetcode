package com.wkodate.leetcode.LC1260_Shift2DGrid;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<Integer> list = new ArrayList<>();
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                list.add(grid[i][j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < rowLen; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < colLen; j++) {
                row.add(list.get((list.size() - (k % list.size()) + (i * colLen + j)) % list.size()));
            }
            ans.add(row);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1));
        System.out.println(s.shiftGrid(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}, 4));
        System.out.println(s.shiftGrid(new int[][]{{1}, {2}, {3}, {4}, {5}, {6}, {7}}, 23));
    }

}
