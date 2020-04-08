package com.wkodate.leetcode.LC0876_MiddleOfTheLinkedList;

import com.wkodate.leetcode.ListNode;

public class Solution2 {

    public ListNode middleNode(ListNode head) {
        ListNode node = head;
        int len = 1;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        for (int i = 0; i < len / 2; i++) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 3
        System.out.println(s.middleNode(ListNode.fromArray(new int[]{1, 2, 3, 4, 5})));
        // 4
        System.out.println(s.middleNode(ListNode.fromArray(new int[]{1, 2, 3, 4, 5, 6})));
    }

}
