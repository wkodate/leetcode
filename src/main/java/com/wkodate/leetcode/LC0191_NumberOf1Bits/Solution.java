package com.wkodate.leetcode.LC0191_NumberOf1Bits;

public class Solution {

    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('1' == c) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(521));
        System.out.println(solution.hammingWeight(2097152));
    }

}
