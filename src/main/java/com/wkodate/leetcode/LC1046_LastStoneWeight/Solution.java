package com.wkodate.leetcode.LC1046_LastStoneWeight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int stone : stones) {
            list.add(stone);
        }
        while (list.size() > 1) {
            Collections.sort(list, Collections.reverseOrder());
            int y = list.get(0);
            int x = list.get(1);
            if (x == y) {
                list.remove(1);
                list.remove(0);
                continue;
            }
            list.set(1, y - x);
            list.remove(0);
        }
        if (list.size() == 0) {
            return 0;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(s.lastStoneWeight(new int[]{2, 2}));
    }

}
