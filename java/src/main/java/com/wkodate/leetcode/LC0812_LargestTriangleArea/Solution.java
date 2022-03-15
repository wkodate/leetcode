package com.wkodate.leetcode.LC0812_LargestTriangleArea;

public class Solution {

    public double largestTriangleArea(int[][] points) {
        double area = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    double a = Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                    double b = Math.sqrt(Math.pow(points[j][0] - points[k][0], 2) + Math.pow(points[j][1] - points[k][1], 2));
                    double c = Math.sqrt(Math.pow(points[k][0] - points[i][0], 2) + Math.pow(points[k][1] - points[i][1], 2));
                    if (a + b <= c || b + c <= a || c + a <= b) {
                        continue;
                    }
                    double s = (a + b + c) / 2;
                    area = Math.max(area, Math.sqrt(s * (s - a) * (s - b) * (s - c)));
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] points = new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
        System.out.println(s.largestTriangleArea(points));
        int[][] points2 = new int[][]{{-35, 19}, {40, 19}, {27, -20}, {35, -3}, {44, 20}, {22, -21}, {35, 33}, {-19, 42}, {11, 47}, {11, 37}};
        System.out.println(s.largestTriangleArea(points2));
    }

}
