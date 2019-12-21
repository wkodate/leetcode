package com.wkodate.leetcode.LC0703_KthLargestElementInAStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthLargest2 {

    private int k;
    private List<Integer> nums = new ArrayList<>();

    public KthLargest2(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            this.nums.add(num);
        }
    }

    public int add(int val) {
        nums.add(val);
        Collections.sort(nums, Collections.reverseOrder());
        return nums.get(k - 1);
    }

    public static void main(String[] args) {
        KthLargest2 kl = new KthLargest2(3, new int[]{4, 5, 8, 2});
        // 4
        System.out.println(kl.add(3));
        // 5
        System.out.println(kl.add(5));
        // 5
        System.out.println(kl.add(10));
        // 8
        System.out.println(kl.add(9));
        // 8
        System.out.println(kl.add(4));
    }

}
