package com.wkodate.leetcode.LC0876_MiddleOfTheLinkedList;

import com.wkodate.leetcode.ListNode;

public class Solution {

    public ListNode middleNode(ListNode head) {
        ListNode current = head;
        ListNode middle = head;
        int i = 0;
        while (current != null) {
            i++;
            current = current.next;
            if (i % 2 == 0) {
                middle = middle.next;
            }
        }
        return middle;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.fromArray(new int[]{1, 2, 3, 4, 5});
        System.out.println(s.middleNode(head));
    }

}
