package com.wkodate.leetcode.LC0056_MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        int[] interval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (current[0] > interval[1]) {
                list.add(interval);
                interval = current;
            } else {
                if (current[1] > interval[1]) {
                    interval[1] = current[1];
                }
            }
        }
        list.add(interval);
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,4]]
        System.out.println(Arrays.deepToString(s.merge(new int[][]{{1, 4}, {2, 3}})));
        // [[1,6],[8,10],[15,18]]
        System.out.println(Arrays.deepToString(s.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        // [[1,5]]
        System.out.println(Arrays.deepToString(s.merge(new int[][]{{1, 4}, {4, 5}})));
        // [[0,4]]
        System.out.println(Arrays.deepToString(s.merge(new int[][]{{1, 4}, {0, 4}})));

    }

}
