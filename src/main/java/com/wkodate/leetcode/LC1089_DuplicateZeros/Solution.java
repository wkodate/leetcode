package com.wkodate.leetcode.LC1089_DuplicateZeros;

import java.util.Arrays;

public class Solution {

    public void duplicateZeros(int[] arr) {
        if (arr.length == 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != 0) {
                continue;
            }
            int prev = arr[i + 1];
            for (int j = i + 1; j < arr.length; j++) {
                if (j == i + 1) {
                    arr[j] = 0;
                    continue;
                }
                int tmp = arr[j];
                arr[j] = prev;
                prev = tmp;
            }
            i++;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,0,0,2,3,0,0,4]
        s.duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
        // [1,0,0,2,3,0,0,4,5]
        s.duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0, 0});
        // [1,2,3]
        s.duplicateZeros(new int[]{1, 2, 3});
        // [0]
        s.duplicateZeros(new int[]{0});
        // [1]
        s.duplicateZeros(new int[]{1});
        // [0, 0]
        s.duplicateZeros(new int[]{0, 0});
        // [0, 0, 0, 0, 0, 0, 0]
        s.duplicateZeros(new int[]{0, 0, 0, 0, 0, 0, 0});
        // [0, 0, 0, 0, 0, 0, 0, 0]
        s.duplicateZeros(new int[]{0, 0, 0, 0, 0, 0, 0, 0});
    }

}
