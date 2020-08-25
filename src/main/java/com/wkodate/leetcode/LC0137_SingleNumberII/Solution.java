package com.wkodate.leetcode.LC0137_SingleNumberII;

public class Solution {

    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        int notThrees = 0;
        for (int n : nums) {
            twos |= ones & n;
            ones ^= n;
            notThrees = ~(ones & twos);
            ones &= notThrees;
            twos &= notThrees;
        }
        return ones;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.singleNumber(new int[] { 3, 2, 2, 2 }));
        // 3
        System.out.println(s.singleNumber(new int[] { 2, 3, 2, 2 }));
        // 3
        System.out.println(s.singleNumber(new int[] { 2, 2, 3, 2 }));
        // 3
        System.out.println(s.singleNumber(new int[] { 2, 2, 2, 3 }));
        // 99
        System.out.println(s.singleNumber(new int[] { 0, 1, 0, 1, 0, 1, 99 }));
    }

}
