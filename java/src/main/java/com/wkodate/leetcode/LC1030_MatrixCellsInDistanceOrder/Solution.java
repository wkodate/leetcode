package com.wkodate.leetcode.LC1030_MatrixCellsInDistanceOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Map<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int d = Math.abs(i - r0) + Math.abs(j - c0);
                List<int[]> list;
                if (!map.containsKey(d)) {
                    list = new ArrayList<>();
                } else {
                    list = map.get(d);
                }
                list.add(new int[]{i, j});
                map.put(d, list);
            }
        }
        List<int[]> ansList = new ArrayList<>();
        for (List<int[]> vList : map.values()) {
            ansList.addAll(vList);
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[0,0],[0,1]]
        System.out.println(Arrays.deepToString(s.allCellsDistOrder(1, 2, 0, 0)));
        // [[0,1],[0,0],[1,1],[1,0]]
        System.out.println(Arrays.deepToString(s.allCellsDistOrder(2, 2, 0, 1)));
        // [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
        System.out.println(Arrays.deepToString(s.allCellsDistOrder(2, 3, 1, 2)));
    }

}
