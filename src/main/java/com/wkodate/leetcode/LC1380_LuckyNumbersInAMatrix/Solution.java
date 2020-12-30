package com.wkodate.leetcode.LC1380_LuckyNumbersInAMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckies = new ArrayList<>();
        boolean[][] minMat = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int minKey = 0;
            int minValue = matrix[i][0];
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] < minValue) {
                    minKey = j;
                    minValue = matrix[i][j];
                }
            }
            minMat[i][minKey] = true;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            int maxKey = 0;
            int maxValue = matrix[0][i];
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] > maxValue) {
                    maxKey = j;
                    maxValue = matrix[j][i];
                }
            }
            if (minMat[maxKey][i]) {
                luckies.add(maxValue);
            }
        }
        return luckies;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [15]
        System.out.println(s.luckyNumbers(new int[][] { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } }));
        // [12]
        System.out.println(s.luckyNumbers(new int[][] { { 1, 10, 4, 2 }, { 9, 3, 8, 7 }, { 15, 16, 17, 12 } }));
        // [7]
        System.out.println(s.luckyNumbers(new int[][] { { 7, 8 }, { 1, 2 } }));
    }

}
