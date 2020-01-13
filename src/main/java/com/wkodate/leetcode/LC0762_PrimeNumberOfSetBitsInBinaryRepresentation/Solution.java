package com.wkodate.leetcode.LC0762_PrimeNumberOfSetBitsInBinaryRepresentation;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int countPrimeSetBits(int L, int R) {
        String rBinStr = Integer.toBinaryString(R);
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(0, false);
        map.put(1, false);
        for (int i = 2; i <= rBinStr.length(); i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    map.put(i, false);
                    break;
                }
            }
            if (!map.containsKey(i)) {
                map.put(i, true);
            }
        }
        int ans = 0;
        for (int i = L; i <= R; i++) {
            if (map.get(Integer.bitCount(i))) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.countPrimeSetBits(6, 10));
        // 5
        System.out.println(s.countPrimeSetBits(10, 15));
    }

}
