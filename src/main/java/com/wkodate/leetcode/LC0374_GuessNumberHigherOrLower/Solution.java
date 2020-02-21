package com.wkodate.leetcode.LC0374_GuessNumberHigherOrLower;

public class Solution extends GuessGame {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                return mid;
            }
            if (guess(mid) < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        s.setPick(6);
        System.out.println(s.guessNumber(10));
        // 4
        s.setPick(4);
        System.out.println(s.guessNumber(10));
        // 1
        s.setPick(1);
        System.out.println(s.guessNumber(10));
        // 10
        s.setPick(10);
        System.out.println(s.guessNumber(10));
        // 1
        s.setPick(1);
        System.out.println(s.guessNumber(4));
        System.out.println(s.guessNumber(3));
        System.out.println(s.guessNumber(2));
        System.out.println(s.guessNumber(1));
        // 2
        s.setPick(2);
        System.out.println(s.guessNumber(2));
        // 1150769282
        s.setPick(1150769282);
        System.out.println(s.guessNumber(1420736637));
    }

}
