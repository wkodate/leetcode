package com.wkodate.leetcode.LC0382_LinkedListRandomNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.wkodate.leetcode.ListNode;

public class Solution {

    Random RANDOM = new Random();
    List<Integer> list;

    public Solution(ListNode head) {
        list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        return list.get(RANDOM.nextInt(list.size()));
    }

    public static void main(String[] args) {
        // Init a singly linked list [1,2,3].
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution s = new Solution(head);
        // getRandom() should return either 1, 2, or 3 randomly.
        // Each element should have equal probability of returning.
        for (int i = 0; i < 10; i++) {
            System.out.println(s.getRandom());
        }
    }
}
