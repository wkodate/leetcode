package com.wkodate.leetcode.LC0374_GuessNumberHigherOrLower;

public class GuessGame {

    private int pick = 0;

    public int guess(int n) {
        if (pick > n) {
            return 1;
        } else if (pick < n) {
            return -1;
        }
        return 0;
    }

    public void setPick(int pick) {
        this.pick = pick;
    }

}
