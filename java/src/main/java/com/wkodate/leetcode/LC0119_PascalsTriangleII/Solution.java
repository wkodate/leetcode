package com.wkodate.leetcode.LC0119_PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        prev.add(1);
        for (int i = 0; i <= rowIndex; i++) {
            current = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    current.add(1);
                } else {
                    current.add(prev.get(j - 1) + prev.get(j));
                }
            }
            prev = current;
        }
        return current;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getRow(4));
    }

}
