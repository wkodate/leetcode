package com.wkodate.leetcode.LC1337_TheKWeakestRowsInAMatrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            map.put(i, count);
        }

        int[] ans = new int[k];
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                (a, b) -> (a.getValue().equals(b.getValue())) ? b.getKey().compareTo(a.getKey()) : b.getValue().compareTo(a.getValue())
        );
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            heap.offer(e);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = heap.poll().getKey();
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] mat = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        System.out.println(Arrays.toString(s.kWeakestRows(mat, 3)));

    }

}
