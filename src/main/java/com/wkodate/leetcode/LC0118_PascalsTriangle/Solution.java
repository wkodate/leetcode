package com.wkodate.leetcode.LC0118_PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> current = new ArrayList<>();
            if (i == 0) {
                current.add(1);
            } else {
                List<Integer> prev = result.get(i - 1);
                for (int j = 0; j < prev.size() + 1; j++) {
                    if (j == 0 || j == prev.size()) {
                        current.add(1);
                        continue;
                    }
                    current.add(prev.get(j - 1) + prev.get(j));
                }
            }
            result.add(current);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generate(0));
        System.out.println(solution.generate(1));
        System.out.println(solution.generate(2));
        System.out.println(solution.generate(3));
    }

}
