package com.wkodate.leetcode.LC0367_ValidPerfectSquare;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public boolean isPerfectSquare(int num) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (i < Math.sqrt(Integer.MAX_VALUE)) {
            set.add(i * i);
            i++;
        }
        return set.contains(num);
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // true
        System.out.println(s.isPerfectSquare(16));
        // false
        System.out.println(s.isPerfectSquare(14));
    }

}
