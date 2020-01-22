package com.wkodate.leetcode.LC0633_SumOfSquareNumbers;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean judgeSquareSum(int c) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (Math.pow(i, 2) <= c) {
            set.add((int) Math.pow(i++, 2));
        }
        for (int j = 0; j <= set.size(); j++) {
            if (set.contains((int) (c - Math.pow(j, 2)))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.judgeSquareSum(5));
        // false
        System.out.println(s.judgeSquareSum(3));
        // true
        System.out.println(s.judgeSquareSum(4));
    }

}
