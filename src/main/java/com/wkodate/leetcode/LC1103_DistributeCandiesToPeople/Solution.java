package com.wkodate.leetcode.LC1103_DistributeCandiesToPeople;

import java.util.Arrays;

public class Solution {

    public int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];
        int i = 1;
        while (candies > i) {
            people[(i - 1) % num_people] += i;
            candies -= i;
            i++;
        }
        people[(i - 1) % num_people] += candies;
        return people;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2,3,1]
        System.out.println(Arrays.toString(s.distributeCandies(7, 4)));
        //// [5,2,3]
        System.out.println(Arrays.toString(s.distributeCandies(10, 3)));
        // [15,18,15,12]
        System.out.println(Arrays.toString(s.distributeCandies(60, 4)));
    }

}
