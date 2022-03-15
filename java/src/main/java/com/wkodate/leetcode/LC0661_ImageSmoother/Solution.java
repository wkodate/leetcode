package com.wkodate.leetcode.LC0661_ImageSmoother;

import java.util.Arrays;

public class Solution {

    public int[][] imageSmoother(int[][] M) {
        int rowLen = M.length;
        int colLen = M[0].length;
        int[][] ans = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int count = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k >= 0 && k < rowLen && l >= 0 && l < colLen) {
                            ans[i][j] += M[k][l];
                            count++;
                        }
                    }
                }
                ans[i][j] /= count;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[0,0,0],[0,0,0],[0,0,0]]
        int[][] m1 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] ans1 = s.imageSmoother(m1);
        for (int i = 0; i < m1.length; i++) {
            System.out.println(Arrays.toString(ans1[i]));
        }
        // [[4,4,5],[5,6,6],[8,9,9],[11,12,12],[13,13,14]]
        int[][] m2 = new int[][]{{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}};
        int[][] ans2 = s.imageSmoother(m2);
        for (int i = 0; i < m2.length; i++) {
            System.out.println(Arrays.toString(ans2[i]));
        }
    }

}
