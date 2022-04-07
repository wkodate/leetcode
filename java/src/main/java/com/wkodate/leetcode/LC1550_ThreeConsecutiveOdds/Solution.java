package com.wkodate.leetcode.LC1550_ThreeConsecutiveOdds;

public class Solution {

    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt >= 3) {
                return true;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
        // true
        System.out.println(s.threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
    }

}
