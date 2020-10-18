package com.wkodate.leetcode.LC1588_SumOfAllOddLengthSubarrays;

public class Solution {

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 1; i <= arr.length; i += 2) {
            for (int j = 0; j <= arr.length - i; j++) {
                for (int k = j; k < j + i; k++) {
                    sum += arr[k];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 58
        System.out.println(s.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
        // 3
        System.out.println(s.sumOddLengthSubarrays(new int[]{1, 2}));
        // 66
        System.out.println(s.sumOddLengthSubarrays(new int[]{10, 11, 12}));
    }

}
