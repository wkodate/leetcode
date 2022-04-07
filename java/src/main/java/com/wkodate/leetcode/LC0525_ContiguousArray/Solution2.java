package com.wkodate.leetcode.LC0525_ContiguousArray;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int findMaxLength(int[] nums) {
        // <count, firstTimeIndex>
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count += 1;
            } else {
                count -= 1;
            }
            if (!map.containsKey(count)) {
                map.put(count, i);
                continue;
            }
            maxlen = Math.max(maxlen, i - map.get(count));
        }
        return maxlen;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 2
        System.out.println(s.findMaxLength(new int[] { 0, 1 }));
        // 2
        System.out.println(s.findMaxLength(new int[] { 0, 1, 0 }));
        // 6
        System.out.println(s.findMaxLength(new int[] { 0, 1, 0, 0, 1, 1, 0 }));
    }

}
