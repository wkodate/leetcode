package com.wkodate.leetcode.LC0970_PowerfulIntegers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= bound; i++) {
            for (int j = 0; j <= bound; j++) {
                int p = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (p > bound) {
                    break;
                }
                set.add(p);
            }
        }
        List<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,3,4,5,7,9,10]
        System.out.println(s.powerfulIntegers(2, 3, 10));
        // [2,4,6,8,10,14]
        System.out.println(s.powerfulIntegers(3, 5, 15));
    }

}
