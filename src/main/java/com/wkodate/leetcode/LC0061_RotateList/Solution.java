package com.wkodate.leetcode.LC0061_RotateList;

import com.wkodate.leetcode.ListNode;

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        ListNode current = head;
        int rot = k % len;
        int startIdx = (len - rot) % len;
        if (startIdx == 0) {
            return head;
        }
        for (int i = 0; i < startIdx; i++) {
            current = current.next;
        }
        ListNode newHead = current;
        current = newHead;
        for (int i = startIdx; i < len - 1; i++) {
            current = current.next;
        }
        current.next = head;
        for (int i = 0; i < startIdx; i++) {
            current = current.next;
        }
        current.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rotateRight(ListNode.fromArray(new int[]{1, 2, 3, 4, 5}), 2));
        System.out.println(s.rotateRight(ListNode.fromArray(new int[]{0, 1, 2}), 4));
        System.out.println(s.rotateRight(ListNode.fromArray(new int[]{}), 2));
        System.out.println(s.rotateRight(ListNode.fromArray(new int[]{0}), 2));
        System.out.println(s.rotateRight(ListNode.fromArray(new int[]{1, 2}), 3));
        System.out.println(s.rotateRight(ListNode.fromArray(new int[]{1, 2}), 2));
    }

}
