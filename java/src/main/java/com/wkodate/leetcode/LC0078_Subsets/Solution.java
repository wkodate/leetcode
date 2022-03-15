package com.wkodate.leetcode.LC0078_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int bit = 0; bit < (1 << nums.length); bit++) {
            StringBuilder sb = new StringBuilder();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if ((1 & (bit >> i)) == 1) {
                    list.add(nums[i]);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> ans = s.subsets(new int[] { 1, 2, 3 });
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

}
