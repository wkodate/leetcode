package com.wkodate.leetcode.LC0167_TwoSumII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i + 1);
        }
        int[] pair = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                pair[0] = i + 1;
                pair[1] = map.get(target - numbers[i]);
                break;
            }
        }
        return pair;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] pair = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(pair));
    }

}
