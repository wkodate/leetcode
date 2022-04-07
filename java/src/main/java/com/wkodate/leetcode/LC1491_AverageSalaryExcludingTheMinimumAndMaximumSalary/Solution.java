package com.wkodate.leetcode.LC1491_AverageSalaryExcludingTheMinimumAndMaximumSalary;

import java.util.Arrays;

public class Solution {

    public double average(int[] salary) {
        Arrays.sort(salary);
        double sum = 0;
        for (int i = 1; i < salary.length - 1; i++) {
            sum += salary[i];
        }
        return sum / (salary.length - 2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2500
        System.out.println(s.average(new int[]{4000, 3000, 1000, 2000}));
        // 2000
        System.out.println(s.average(new int[]{1000, 2000, 3000}));
        // 3500
        System.out.println(s.average(new int[]{6000, 5000, 4000, 3000, 2000, 1000}));
        // 4750
        System.out.println(s.average(new int[]{8000, 9000, 2000, 3000, 6000, 1000}));
    }

}
