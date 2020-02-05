package com.wkodate.leetcode.LC0019_RemoveNthNodeFromEndOfList;

import com.wkodate.leetcode.ListNode;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node1 = head;
        int len = 0;
        while (node1 != null) {
            len++;
            node1 = node1.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node2 = dummy;
        int i = 0;
        while (i <= len) {
            if (len - i <= n) {
                break;
            }
            node2 = node2.next;
            i++;
        }
        node2.next = node2.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeNthFromEnd(ListNode.fromArray(new int[]{1, 2, 3, 4, 5}), 2));
        System.out.println(s.removeNthFromEnd(ListNode.fromArray(new int[]{1, 2, 3}), 3));
        System.out.println(s.removeNthFromEnd(ListNode.fromArray(new int[]{1}), 1));
    }

}
