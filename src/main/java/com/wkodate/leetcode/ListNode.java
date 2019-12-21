package com.wkodate.leetcode;

public class ListNode {
    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode generate(int[] in) {
        if (in.length == 0) {
            return null;
        }
        ListNode head = new ListNode(in[0]);
        ListNode prev = head;
        for (int i = 0; i < in.length; i++) {
            ListNode current = new ListNode(in[i]);
            prev.next = current;
            prev = current;
        }
        return head;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

}
