package com.wkodate.leetcode.LC0074_SearchA2DMatrix;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                set.add(matrix[i][j]);
            }
        }
        return set.contains(target);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.searchMatrix(new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}},
                3));
        // false
        System.out.println(s.searchMatrix(new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}},
                13));
    }

}
