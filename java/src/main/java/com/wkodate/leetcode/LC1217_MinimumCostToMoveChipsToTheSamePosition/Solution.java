package com.wkodate.leetcode.LC1217_MinimumCostToMoveChipsToTheSamePosition;

public class Solution {

    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd,even);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minCostToMoveChips(new int[]{1, 2, 3}));
        // 2
        System.out.println(s.minCostToMoveChips(new int[]{2, 2, 2, 3, 3}));
        // 1
        System.out.println(s.minCostToMoveChips(new int[]{1, 1000000000}));
    }
}
