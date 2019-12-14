package com.wkodate.leetcode.LC0461_HammingDistance;

public class Solution {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            count++;
            xor = xor & (xor - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 2
        System.out.println(solution.hammingDistance(1, 4));
        // 1
        System.out.println(solution.hammingDistance(3, 1));
        // 0
        System.out.println(solution.hammingDistance(0, 0));
    }

}
