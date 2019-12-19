package com.wkodate.leetcode.LC0605_CanPlaceFlowers;

public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        boolean adjacent = false;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                adjacent = true;
                continue;
            } else {
                if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1) {
                    adjacent = true;
                    continue;
                }
                if (!adjacent) {
                    count++;
                    adjacent = true;
                } else {
                    adjacent = false;
                }
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // True
        System.out.println(s.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        // False
        System.out.println(s.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        // False
        System.out.println(s.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
        // True
        System.out.println(s.canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
    }

}
