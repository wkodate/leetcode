package com.wkodate.leetcode.LC1431_KidsWithTheGreatestNumberOfCandies;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 1;
        for (int candy : candies) {
            max = Math.max(candy, max);
        }
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [true, true, true, false, true]
        System.out.println(s.kidsWithCandies(new int[] { 2, 3, 5, 1, 3 }, 3));
    }

}
