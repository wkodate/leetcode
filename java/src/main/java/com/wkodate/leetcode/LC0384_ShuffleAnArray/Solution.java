package com.wkodate.leetcode.LC0384_ShuffleAnArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    int[] org;
    List<Integer> list;

    public Solution(int[] nums) {
        this.org = nums;
        this.list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return org;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        Collections.shuffle(list);
        int[] shuffled = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            shuffled[i] = list.get(i);
        }
        return shuffled;
    }

    public static void main(String[] args) {
        // Init an array with set 1, 2, and 3.
        int[] nums = {1, 2, 3};
        Solution solution = new Solution(nums);

        // Shuffle the array [1,2,3] and return its result.
        // Any permutation of [1,2,3] must equally likely to be returned.
        System.out.println(Arrays.toString(solution.shuffle()));

        // Resets the array back to its original configuration [1,2,3].
        System.out.println(Arrays.toString(solution.reset()));

        // Returns the random shuffling of array [1,2,3].
        System.out.println(Arrays.toString(solution.shuffle()));
    }

}
