package com.wkodate.leetcode.ThirtyDayLeetCodingChallenge.LeftmostColumnWithAtLeastAOne;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static class BinaryMatrix {

        private int[][] mat;

        public BinaryMatrix(int[][] mat) {
            this.mat = mat;
        }

        public int get(int x, int y) {
            return mat[x][y];
        }

        public List<Integer> dimensions() {
            List<Integer> list = new ArrayList<>();
            list.add(mat.length);
            list.add(mat[0].length);
            return list;
        }

    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> d = binaryMatrix.dimensions();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < d.get(0); i++) {
            int left = -1;
            int right = d.get(1);
            int mid;
            while (right - left > 1) {
                mid = left + (right - left) / 2;
                if (binaryMatrix.get(i, mid) >= 1) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            min = Math.min(min, right);
        }
        if (min >= d.get(1)) {
            return -1;
        }
        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.leftMostColumnWithOne(new BinaryMatrix(new int[][]{{0, 0}, {1, 1}})));
        // 1
        System.out.println(s.leftMostColumnWithOne(new BinaryMatrix(new int[][]{{0, 0}, {0, 1}})));
        // -1
        System.out.println(s.leftMostColumnWithOne(new BinaryMatrix(new int[][]{{0, 0}, {0, 0}})));
        // 1
        System.out.println(s.leftMostColumnWithOne(new BinaryMatrix(new int[][]{{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}})));
        // 0
        System.out.println(s.leftMostColumnWithOne(new BinaryMatrix(new int[][]{
                {1, 1, 1, 1, 1}, {0, 0, 0, 1, 1}, {0, 0, 1, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}})));
    }
}
