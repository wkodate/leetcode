package com.wkodate.leetcode.LC0119_PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ans.add(list);
        for (int i = 2; i <= 34; i++) {
            List<Integer> l = new ArrayList<>();
            List<Integer> prev = ans.get(i - 2);
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    l.add(1);
                } else {
                    l.add(prev.get(j - 1) + prev.get(j));
                }
            }
            ans.add(l);
        }
        return ans.get(rowIndex);
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // [1,3,3,1]
        System.out.println(s.getRow(3));
        System.out.println(s.getRow(33));
    }

}
