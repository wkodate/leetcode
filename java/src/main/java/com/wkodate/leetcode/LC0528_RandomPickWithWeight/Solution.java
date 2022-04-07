package com.wkodate.leetcode.LC0528_RandomPickWithWeight;

import java.util.Random;

public class Solution {

    private int[] w;
    private double[] p;
    Random r = new Random();

    public Solution(int[] w) {
        this.w = w;
        double sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
        }
        p = new double[w.length];
        p[0] = w[0] / sum;
        for (int i = 1; i < w.length; i++) {
            p[i] = p[i - 1] + w[i] / sum;
        }
    }

    public int pickIndex() {
        Double d = r.nextDouble();
        for (int i = 0; i < p.length; i++) {
            if (d <= p[i]) {
                return i;
            }
        }
        return p.length - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution(new int[] { 1 });
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println();
        Solution s2 = new Solution(new int[] { 1, 3 });
        System.out.println(s2.pickIndex());
        System.out.println(s2.pickIndex());
        System.out.println(s2.pickIndex());
        System.out.println(s2.pickIndex());
        System.out.println(s2.pickIndex());
        System.out.println();
        Solution s3 = new Solution(new int[] { 3, 14, 1, 7 });
        System.out.println(s3.pickIndex());
        System.out.println(s3.pickIndex());
        System.out.println(s3.pickIndex());
        System.out.println(s3.pickIndex());
        System.out.println(s3.pickIndex());
    }

}
