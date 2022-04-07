package com.wkodate.leetcode.LC0264_UglyNumberII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public int nthUglyNumber(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < 14; k++) {
                    set.add((int) (Math.pow(2, i) * Math.pow(3, j) * Math.pow(5, k)));
                }
            }

        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.get(n - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 12
        System.out.println(s.nthUglyNumber(10));
        // 750
        System.out.println(s.nthUglyNumber(78));
        // 1024
        System.out.println(s.nthUglyNumber(87));
        //
        System.out.println(s.nthUglyNumber(257));
        System.out.println(s.nthUglyNumber(1690));
    }

}
