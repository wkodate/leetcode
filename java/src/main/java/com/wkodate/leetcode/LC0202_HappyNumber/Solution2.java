package com.wkodate.leetcode.LC0202_HappyNumber;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            String[] narr = String.valueOf(n).split("");
            int sum = 0;
            for (int i = 0; i < narr.length; i++) {
                sum += Math.pow(Integer.parseInt(narr[i]), 2);
            }
            n = sum;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // true
        System.out.println(s.isHappy(19));
    }

}
