package com.wkodate.leetcode.LC1103_DistributeCandiesToPeople;

import java.util.Arrays;

public class Solution2 {

    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int m = 0;
        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                ans[i] += Math.min(m + i + 1, candies);
                candies -= m + i + 1;
                if (candies <= 0) {
                    break;
                }
            }
            m += num_people;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // [1,2,3,1]
        System.out.println(Arrays.toString(s.distributeCandies(7, 4)));
        // [5,2,3]
        System.out.println(Arrays.toString(s.distributeCandies(10, 3)));
    }

}
