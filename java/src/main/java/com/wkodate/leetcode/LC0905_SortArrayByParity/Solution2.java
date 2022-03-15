package com.wkodate.leetcode.LC0905_SortArrayByParity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

    public int[] sortArrayByParity(int[] A) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                even.add(A[i]);
            } else {
                odd.add(A[i]);
            }
        }
        even.addAll(odd);
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            ans[i] = even.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // [2,4,3,1]
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[] { 3, 1, 2, 4 })));
    }

}
