package com.wkodate.leetcode.LC0973_KClosestPointsToOrigin;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    class Point {
        private int x;
        private int y;
        private int d;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> heap = new PriorityQueue<>((n1, n2) -> n2.d - n1.d);
        for (int[] point : points) {
            Point p = new Point(point[0], point[1], (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2)));
            heap.add(p);
            if (heap.size() > K) {
                heap.poll();
            }
        }
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++) {
            Point p = heap.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[3,3], [-2,4]]
        System.out.println(Arrays.deepToString(s.kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2)));
        // [[-2.2]]
        System.out.println(Arrays.deepToString(s.kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1)));
    }

}
