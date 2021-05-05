package com.wkodate.leetcode.LC1672_RichestCustomerWealth;

public class Solution {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                sum += accounts[i][j];
            }
            max= Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximumWealth(new int[][] {
                { 1, 2, 3 },
                { 3, 2, 1 }
        }));
        System.out.println(s.maximumWealth(new int[][] {
                { 1, 5 },
                { 7, 3 },
                { 3, 5 }
        }));
        System.out.println(s.maximumWealth(new int[][] {
                { 2, 8, 7 },
                { 7, 1, 3 },
                { 1, 9, 5 }
        }));
    }

}
