package com.wkodate.leetcode.LC0849_MaximizeDistanceToClosestPerson;

import java.util.Arrays;

public class Solution {

    public int maxDistToClosest(int[] seats) {
        int[] distance = new int[seats.length];
        int dis = seats.length - 1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                dis = 0;
            }
            distance[i] = dis++;
        }
        dis = seats.length - 1;
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                dis = 0;
            }
            distance[i] = Math.min(distance[i], dis++);
        }
        int max = 0;
        for (int i = 0; i < distance.length; i++) {
            max = Math.max(max, distance[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        // 3
        System.out.println(s.maxDistToClosest(new int[]{1, 0, 0, 0}));
        // 3
        System.out.println(s.maxDistToClosest(new int[]{0, 0, 0, 1}));
        // 1
        System.out.println(s.maxDistToClosest(new int[]{0, 1, 0, 1, 0}));
    }

}
