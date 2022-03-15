package com.wkodate.leetcode.LC0881_BoatsToSavePeople;

import java.util.Arrays;

public class Solution {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        boolean[] used = new boolean[people.length];
        int cnt = 0;
        int i = 0;
        while (i <= people.length - 1) {
            int j = people.length - 1;
            if (used[i]) {
                i++;
                continue;
            }
            if (people[i] > limit) {
                break;
            }
            while (j > i) {
                if (used[j] || people[i] + people[j] > limit) {
                    j--;
                    continue;
                }
                used[i] = true;
                used[j] = true;
                cnt++;
                break;
            }
            if (j == i) {
                used[i] = true;
                cnt++;
            }
            i++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.numRescueBoats(new int[] { 3, 3, 2, 1 }, 3));
        // 1
        System.out.println(s.numRescueBoats(new int[] { 1, 2 }, 3));
        // 4
        System.out.println(s.numRescueBoats(new int[] { 3, 5, 3, 4 }, 5));
    }

}
