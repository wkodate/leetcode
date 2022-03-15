package com.wkodate.leetcode.LC0066_PlusOne;

import java.util.Arrays;

public class Solution2 {

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= -1) {
            if (i == -1) {
                int[] ans = new int[digits.length + 1];
                ans[0] = 1;
                for (int j = 0; j < digits.length; j++) {
                    ans[j + 1] = 0;
                }
                return ans;
            }
            if (digits[i] != 9) {
                digits[i]++;
                break;
            }
            digits[i] = 0;
            i--;
        }
        return digits;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // [1,2,4]
        System.out.println(Arrays.toString(s.plusOne(new int[] { 1, 2, 3 })));
        // [4,3,2,2]
        System.out.println(Arrays.toString(s.plusOne(new int[] { 4, 3, 2, 1 })));
        // [9,0,0,0]
        System.out.println(Arrays.toString(s.plusOne(new int[] { 8, 9, 9, 9 })));
        // [9,8,7,6,5,4,3,2,1,1]
        System.out.println(Arrays.toString(s.plusOne(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 })));
        // [7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,7]
        System.out.println(Arrays.toString(s.plusOne(new int[] {
                7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7,
                9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6
        })));
    }

}
