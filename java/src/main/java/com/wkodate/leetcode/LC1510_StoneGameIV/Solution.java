package com.wkodate.leetcode.LC1510_StoneGameIV;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean dfs(Map<Integer, Boolean> cache, int remain) {
        if (cache.containsKey(remain)) {
            return cache.get(remain);
        }
        int sqrt_root = (int) Math.sqrt(remain);
        for (int i = 1; i <= sqrt_root; i++) {
            // if there is any chance to make the opponent lose the game in the next round,
            // then the current player will win.
            if (!dfs(cache, remain - i * i)) {
                cache.put(remain, true);
                return true;
            }
        }
        cache.put(remain, false);
        return false;
    }

    public boolean winnerSquareGame(int n) {
        Map<Integer, Boolean> cache = new HashMap<>();
        cache.put(0, false);
        return dfs(cache, n);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.winnerSquareGame(8));
        // false
        System.out.println(s.winnerSquareGame(7));
        // true
        System.out.println(s.winnerSquareGame(1));
        // false
        System.out.println(s.winnerSquareGame(2));
        // true
        System.out.println(s.winnerSquareGame(4));
        // false
        System.out.println(s.winnerSquareGame(17));

    }

}
