package com.wkodate.leetcode.LC1329_SortTheMatrixDiagonally;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int[][] diagonalSort(int[][] mat) {
        for (int start = mat.length; start >= 0; start--) {
            int row = start;
            int col = 0;
            List<Integer> list = new ArrayList<>();
            while (row < mat.length && col < mat[0].length) {
                list.add(mat[row][col]);
                row++;
                col++;
            }
            Collections.sort(list);
            int r = start;
            int c = 0;
            while (r < mat.length && c < mat[0].length) {
                mat[r][c] = list.get(c++);
                r++;
            }
        }
        for (int start = 1; start < mat[0].length; start++) {
            int row = 0;
            int col = start;
            List<Integer> list = new ArrayList<>();
            while (row < mat.length && col < mat[0].length) {
                list.add(mat[row][col]);
                row++;
                col++;
            }
            Collections.sort(list);
            int r = 0;
            int c = start;
            while (r < mat.length && c < mat[0].length) {
                mat[r][c] = list.get(r++);
                c++;
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
        System.out.println(Arrays.deepToString(s.diagonalSort(new int[][]{
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}
        })));
    }

}
