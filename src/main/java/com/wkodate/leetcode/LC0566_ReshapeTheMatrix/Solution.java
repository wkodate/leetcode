package com.wkodate.leetcode.LC0566_ReshapeTheMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int orgR = nums.length;
        int orgC = nums[0].length;
        if (orgR * orgC != r * c) {
            return nums;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < orgR; i++) {
            for (int j = 0; j < orgC; j++) {
                list.add(nums[i][j]);
            }
        }
        int[][] ans = new int[r][c];
        int k = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = list.get(k++);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] ans1 = s.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);
        for (int[] ans : ans1) {
            System.out.println(Arrays.toString(ans));
        }
        int[][] ans2 = s.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 4);
        for (int[] ans : ans2) {
            System.out.println(Arrays.toString(ans));
        }
    }

}
