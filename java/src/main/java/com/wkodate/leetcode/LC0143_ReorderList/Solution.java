package com.wkodate.leetcode.LC0143_ReorderList;

import com.wkodate.leetcode.ListNode;

public class Solution {

    public void reorderList(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            len++;
        }
        ListNode current = head;
        ListNode last = head;
        for (int i = 0; i < (len + 1) / 2 - 1; i++) {
            ListNode prev = last;
            while (last.next != null) {
                prev = last;
                last = last.next;
            }
            ListNode next = current.next;
            prev.next = null;
            last.next = next;
            current.next = last;
            current = next;
        }
        System.out.println(head);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1->4->2->3
        s.reorderList(ListNode.fromArray(new int[] { 1, 2, 3, 4 }));
        // 1->5->2->4->3.
        s.reorderList(ListNode.fromArray(new int[] { 1, 2, 3, 4, 5 }));
    }

}
