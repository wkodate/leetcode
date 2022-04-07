package com.wkodate.leetcode.LC0303_RangeSumQueryImmutable;

public class NumArray {

    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        NumArray s = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        // 1
        System.out.println(s.sumRange(0, 2));
        // -1
        System.out.println(s.sumRange(2, 5));
        // -3
        System.out.println(s.sumRange(0, 5));
    }

}
