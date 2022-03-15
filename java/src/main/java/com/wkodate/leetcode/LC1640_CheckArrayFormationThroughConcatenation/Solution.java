package com.wkodate.leetcode.LC1640_CheckArrayFormationThroughConcatenation;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> piecesHeadIdx = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            piecesHeadIdx.put(pieces[i][0], i);
        }
        int idx = 0;
        while(idx < arr.length) {
            if (!piecesHeadIdx.containsKey(arr[idx])){
                return false;
            }
            int[] piecesArr = pieces[piecesHeadIdx.get(arr[idx])];
            for (int i = 0; i < piecesArr.length; i++) {
                if (arr[idx] != piecesArr[i]) {
                    return false;
                }
                idx++;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.canFormArray(new int[]{85}, new int[][]{{85}}));
        // true
        System.out.println(s.canFormArray(new int[]{15, 88}, new int[][]{{88}, {15}}));
        // false
        System.out.println(s.canFormArray(new int[]{49, 18, 16}, new int[][]{{16, 18, 49}}));
        // true
        System.out.println(s.canFormArray(new int[]{91, 4, 64, 78}, new int[][]{{78}, {4, 64}, {91}}));
        // false
        System.out.println(s.canFormArray(new int[]{1, 3, 5, 7}, new int[][]{{2, 4, 6, 8}}));
    }

}
