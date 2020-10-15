package com.wkodate.leetcode.LC0497_RandomPointInNonOverlappingRectangles;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

public class Solution {

    private int[][] rects;
    private Random rand;
    private TreeMap<Integer, Integer> map;
    private int sum;

    public Solution(int[][] rects) {
        rand = new Random();
        map = new TreeMap<>();
        sum = 0;
        this.rects = rects;
        for (int i = 0; i < rects.length; i++) {
            sum += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            map.put(sum, i);
        }
    }

    public int[] pick() {
        int num = map.ceilingKey(rand.nextInt(sum) + 1);
        int[] xy = rects[map.get(num)];
        return new int[] { xy[0] + rand.nextInt(xy[2] - xy[0] + 1), xy[1] + rand.nextInt(xy[3] - xy[1] + 1) };
    }

    public static void main(String[] args) {
        // [null,[4,1],[4,1],[3,3]]
        Solution s = new Solution(new int[][] { { 1, 1, 5, 5 } });
        System.out.println(Arrays.toString(s.pick()));
        System.out.println(Arrays.toString(s.pick()));
        System.out.println(Arrays.toString(s.pick()));

        // [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
        Solution s2 = new Solution(new int[][] { { -2, -2, -1, -1 }, { 1, 0, 3, 0 } });
        System.out.println(Arrays.toString(s2.pick()));
        System.out.println(Arrays.toString(s2.pick()));
        System.out.println(Arrays.toString(s2.pick()));

        Solution s3 = new Solution(new int[][] { { -5, -5, -1, -1 } });
        System.out.println(Arrays.toString(s3.pick()));
        System.out.println(Arrays.toString(s3.pick()));
        System.out.println(Arrays.toString(s3.pick()));
    }

}
