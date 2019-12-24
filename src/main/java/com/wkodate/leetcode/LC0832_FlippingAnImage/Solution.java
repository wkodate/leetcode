package com.wkodate.leetcode.LC0832_FlippingAnImage;

import java.util.Arrays;

public class Solution {

    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] row : A) {
            for (int i = 0; i < (row.length + 1) / 2; i++) {
                int tmp = row[i] ^ 1;
                row[i] = row[row.length - i - 1] ^ 1;
                row[row.length - i - 1] = tmp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,0,0],[0,1,0],[1,1,1]]
        int[][] in1 = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] out1 = s.flipAndInvertImage(in1);
        for (int[] row : out1) {
            System.out.println(Arrays.toString(row));
        }
        // [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
        int[][] in2 = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        int[][] out2 = s.flipAndInvertImage(in2);
        for (int[] row : out2) {
            System.out.println(Arrays.toString(row));
        }
    }

}
