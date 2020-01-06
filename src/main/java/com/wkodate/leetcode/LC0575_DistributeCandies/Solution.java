package com.wkodate.leetcode.LC0575_DistributeCandies;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.distributeCandies(new int[]{1, 2, 3, 4}));
    }

}
