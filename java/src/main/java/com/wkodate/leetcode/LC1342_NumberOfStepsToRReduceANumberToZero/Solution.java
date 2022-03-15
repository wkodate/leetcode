package com.wkodate.leetcode.LC1342_NumberOfStepsToRReduceANumberToZero;

public class Solution {

    public int numberOfSteps(int num) {
        int count = 0;
        while (true) {
            if (num == 0) {
                return count;
            }
            count++;
            if (num % 2 == 1) {
                num -= 1;
                continue;
            }
            num /= 2;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.numberOfSteps(14));
        // 4
        System.out.println(s.numberOfSteps(8));
        // 12
        System.out.println(s.numberOfSteps(123));
    }

}
