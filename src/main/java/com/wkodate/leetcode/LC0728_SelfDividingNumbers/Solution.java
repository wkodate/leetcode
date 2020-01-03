package com.wkodate.leetcode.LC0728_SelfDividingNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean dividable = true;
            for (int j = 0; j < String.valueOf(i).length(); j++) {
                int num = String.valueOf(i).charAt(j) - '0';
                if (num == 0 || i % num != 0) {
                    dividable = false;
                    break;
                }
            }
            if (dividable) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
        System.out.println(s.selfDividingNumbers(1, 22).toString());
    }

}
