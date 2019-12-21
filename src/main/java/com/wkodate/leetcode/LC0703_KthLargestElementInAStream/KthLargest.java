package com.wkodate.leetcode.LC0703_KthLargestElementInAStream;

import java.util.PriorityQueue;

public class KthLargest {

    private int k;
    private PriorityQueue<Integer> nums = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            this.nums.add(num);
            if (this.nums.size() > k) {
                this.nums.poll();
            }
        }
    }

    public int add(int val) {
        nums.add(val);
        if (nums.size() > k) {
            nums.poll();
        }
        return nums.peek();
    }

    public static void main(String[] args) {
        KthLargest kl = new KthLargest(3, new int[]{4, 5, 8, 2});
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
