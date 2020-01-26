package com.wkodate.leetcode.LC0498_DiagonalTraverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        List<Integer> ansList = new ArrayList<>();
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        List<Integer> intermediate = new ArrayList<>();

        for (int count = 0; count < rLen + cLen - 1; count++) {
            intermediate.clear();
            int r = 0;
            int c = count;
            if (count >= cLen) {
                r = count - cLen + 1;
            }
            if (count >= cLen) {
                c = cLen - 1;
            }

            while (r < rLen && c >= 0) {
                intermediate.add(matrix[r][c]);
                r++;
                c--;
            }

            if (count % 2 == 0) {
                Collections.reverse(intermediate);
            }
            ansList.addAll(intermediate);
        }
        int[] ans = new int[rLen * cLen];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2,4,7,5,3,6,8,9]
        int[][] matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(s.findDiagonalOrder(matrix1)));
        // [3,2]
        int[][] matrix2 = new int[][]{{3}, {2}};
        System.out.println(Arrays.toString(s.findDiagonalOrder(matrix2)));

    }


}
