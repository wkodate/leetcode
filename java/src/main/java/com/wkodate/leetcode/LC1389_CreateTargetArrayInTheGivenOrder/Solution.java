package com.wkodate.leetcode.LC1389_CreateTargetArrayInTheGivenOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < index.length; i++) {
            list.add(index[i], nums[i]);
        }
        int[] ans = new int[index.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0,4,1,3,2
        System.out.println(Arrays.toString(s.createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1})));
        // 0,1,2,3,4
        System.out.println(Arrays.toString(s.createTargetArray(new int[]{1, 2, 3, 4, 0}, new int[]{0, 1, 2, 3, 0})));
        // 1
        System.out.println(Arrays.toString(s.createTargetArray(new int[]{1}, new int[]{0})));
    }

}
