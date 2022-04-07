package com.wkodate.leetcode.LC0303_RangeSumQueryImmutable;

public class NumArray2 {

    int[] sum;

    public NumArray2(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public static void main(String[] args) {
        NumArray2 s = new NumArray2(new int[]{-2, 0, 3, -5, 2, -1});
        // 1
        System.out.println(s.sumRange(0, 2));
        // -1
        System.out.println(s.sumRange(2, 5));
        // -3
        System.out.println(s.sumRange(0, 5));
    }

}
