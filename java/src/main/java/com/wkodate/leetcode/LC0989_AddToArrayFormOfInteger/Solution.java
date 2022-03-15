package com.wkodate.leetcode.LC0989_AddToArrayFormOfInteger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ans = new ArrayList<>();
        int i = A.length - 1;
        int cur = K;
        while (i >= 0 || cur > 0) {
            if (i >= 0) {
                cur += A[i];
            }
            ans.add(cur % 10);
            cur /= 10;
            i--;
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1234
        System.out.println(s.addToArrayForm(new int[]{1, 2, 0, 0}, 34).toString());
        // 455
        System.out.println(s.addToArrayForm(new int[]{2, 7, 4}, 181).toString());
        // 1021
        System.out.println(s.addToArrayForm(new int[]{2, 1, 5}, 806).toString());
        // 10000000000
        System.out.println(s.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1).toString());
        // 12630717197566440579
        System.out.println(s.addToArrayForm(new int[]{1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 7, 5, 6, 6, 4, 4, 0, 0, 6, 3}, 516).toString());
        // 23
        System.out.println(s.addToArrayForm(new int[]{0}, 23).toString());
    }

}
