package com.wkodate.leetcode.LC0066_PlusOne;

import java.util.Arrays;

public class Solution {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9, 9, 9})));
    }

}
