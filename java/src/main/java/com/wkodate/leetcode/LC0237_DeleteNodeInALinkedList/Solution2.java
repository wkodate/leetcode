package com.wkodate.leetcode.LC0237_DeleteNodeInALinkedList;

import com.wkodate.leetcode.ListNode;

public class Solution2 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.deleteNode(new ListNode(5));
        s.deleteNode(new ListNode(1));
    }

}
