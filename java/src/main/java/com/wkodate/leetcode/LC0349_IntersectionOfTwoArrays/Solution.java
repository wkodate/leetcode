package com.wkodate.leetcode.LC0349_IntersectionOfTwoArrays;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num1 : nums1) {
            set1.add(num1);
        }
        for (int num2 : nums2) {
            set2.add(num2);
        }
        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        int idx = 0;
        for (int s1 : set1) {
            result[idx++] = s1;
        }
        return result;
    }

    public static void main(String[] args) {
    }

}
