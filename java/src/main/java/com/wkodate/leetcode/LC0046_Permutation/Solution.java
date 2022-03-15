package com.wkodate.leetcode.LC0046_Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    List<List<Integer>> ans;

    private void perm(int[] nums, Set<Integer> set, int idx, int[] n) {
        if (idx >= nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(n[i]);
            }
            ans.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            n[idx++] = nums[i];
            perm(nums, set, idx, n);
            set.remove(nums[i]);
            idx--;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        perm(nums, new HashSet<>(), 0, new int[nums.length]);
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [
        //  [1,2,3],
        //  [1,3,2],
        //  [2,1,3],
        //  [2,3,1],
        //  [3,1,2],
        //  [3,2,1]
        //]
        List<List<Integer>> lists1 = s.permute(new int[]{1, 2, 3});
        for (List<Integer> list1 : lists1) {
            System.out.println(list1.toString());
        }

        // [[0,1],[1,0]]
        List<List<Integer>> lists2 = s.permute(new int[]{0, 1});
        for (List<Integer> list2 : lists2) {
            System.out.println(list2.toString());
        }
    }

}
