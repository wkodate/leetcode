package com.wkodate.leetcode.LC0060_PermutationSequence;

import java.util.Arrays;
import java.util.List;

public class Solution {

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        Arrays.toString(nums);
    }

    private static void permutate(char[] c, String word, int len, List<String> list) {
        if (word.length() >= len) {
            list.add(word);
            return;
        }
        for (int i = 0; i < c.length; i++) {
            char[] nodup = new char[c.length - 1];
            int idx = 0;
            for (int j = 0; j < c.length; j++) {
                if (i == j) {
                    continue;
                }
                nodup[idx++] = c[j];
            }
            permutate(nodup, word + c[i], len, list);
        }
    }

    /**
     public String getPermutation(int n, int k) {
     StringBuilder nums = new StringBuilder();
     for (int i = 1; i <= n; i++) {
     nums.append(i);
     }
     List<String> list = new ArrayList<>();
     permutate(nums.toString().toCharArray(), "", n, list);
     return list.get(k - 1);
     }
     */

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }

        for (int i = 0; i < k - 1; i++) {
            nextPermutation(nums);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //
        System.out.println(s.getPermutation(9, 296662));
        // 213
        System.out.println(s.getPermutation(3, 3));
        // 2314
        System.out.println(s.getPermutation(4, 9));
    }

}
