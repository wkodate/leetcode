package com.wkodate.leetcode.LC1492_TheKthFactorOfN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    private List<Integer> divisors(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i != 0) {
                continue;
            }
            list.add(i);
            if (i != 1 && i * i != n) {
                list.add(n / i);
            }
        }
        if (n != 1) {
            list.add(n);
        }
        Collections.sort(list);
        return list;
    }


    public int kthFactor(int n, int k) {
        List<Integer> d = divisors(n);
        if (d.size() < k) {
            return -1;
        }
        return d.get(k - 1);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.kthFactor(12, 3));
        // 7
        System.out.println(s.kthFactor(7, 2));
        // -1
        System.out.println(s.kthFactor(4, 4));
        // 1
        System.out.println(s.kthFactor(1, 1));
        // 4
        System.out.println(s.kthFactor(1000, 3));

    }

}
