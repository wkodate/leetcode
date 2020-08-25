package com.wkodate.leetcode.LC0957_PrisonCellsAfterNDays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[] prisonAfterNDays(int[] cells, int N) {
        if (N == 0) {
            return cells;
        }
        List<int[]> prisonList = new ArrayList<>();
        int[] day1 = new int[cells.length];
        int i = 0;
        int[] prev = cells;
        while (i < N) {
            int[] pc = new int[cells.length];
            if (i != 0) {
                prev = prisonList.get(i - 1);
            }
            for (int j = 1; j < cells.length - 1; j++) {
                if (prev[j - 1] == prev[j + 1]) {
                    pc[j] = 1;
                } else {
                    pc[j] = 0;
                }
            }
            if (i == 0) {
                for (int j = 0; j < cells.length; j++) {
                    day1[j] = pc[j];
                }
            } else {
                boolean matchedDay1 = true;
                for (int j = 0; j < cells.length; j++) {
                    if (pc[j] != day1[j]) {
                        matchedDay1 = false;
                        break;
                    }
                }
                if (matchedDay1) {
                    break;
                }
            }
            i++;
            prisonList.add(pc);
        }
        if (i == N) {
            return prisonList.get(i - 1);
        } else {
            return prisonList.get((N - 1) % prisonList.size());
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,0,1,1,1,1,1,0]
        System.out.println(
                Arrays.toString(s.prisonAfterNDays(new int[] { 1, 0, 0, 1, 0, 0, 1, 0 }, 1000000000)));
        // [0,0,1,1,0,0,0,0]
        System.out.println(Arrays.toString(s.prisonAfterNDays(new int[] { 0, 1, 0, 1, 1, 0, 0, 1 }, 7)));
    }

}
