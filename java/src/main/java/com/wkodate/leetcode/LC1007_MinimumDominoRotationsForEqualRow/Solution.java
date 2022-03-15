package com.wkodate.leetcode.LC1007_MinimumDominoRotationsForEqualRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {


    private int rotate(int[] a, int[] b, int target) {
        int cnt = 0;
        for (int j = 0; j < a.length; j++) {
            if (a[j] != target && b[j] != target) {
                return Integer.MAX_VALUE;
            }
            if (a[j] == target) {
                continue;
            }
            cnt++;
        }
        return cnt;
    }

    public int minDominoRotations(int[] A, int[] B) {
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            ans = Math.min(rotate(A, B, i), ans);
            ans = Math.min(rotate(B, A, i), ans);
        }
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
        // -1
        System.out.println(s.minDominoRotations(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4}));
        // 0
        System.out.println(s.minDominoRotations(new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}));
    }


}
