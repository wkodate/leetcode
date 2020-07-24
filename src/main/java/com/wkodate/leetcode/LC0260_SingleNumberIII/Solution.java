package com.wkodate.leetcode.LC0260_SingleNumberIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        int[] ans = new int[2];
        List<Integer> list = new ArrayList<>(set);
        ans[0] = list.get(0);
        ans[1] = list.get(1);
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [3,5]
        System.out.println(Arrays.toString(s.singleNumber(new int[] { 1, 2, 1, 3, 2, 5 })));
    }

}
