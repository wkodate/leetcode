package com.wkodate.leetcode.LC0203_RemoveLinkedListElements;

import com.wkodate.leetcode.ListNode;

public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode headPrev = new ListNode(0);
        headPrev.next = head;
        ListNode current = head;
        ListNode prev = headPrev;
        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return headPrev.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1->2->3->4->5
        ListNode ln = ListNode.fromArray(new int[]{1, 2, 6, 3, 4, 5, 6});
        System.out.println(s.removeElements(ln, 6));
        // null
        System.out.println(s.removeElements(null, 0));
        // 2->3
        ListNode ln2 = ListNode.fromArray(new int[]{1, 2, 3});
        System.out.println(s.removeElements(ln2, 1));
        // null
        System.out.println(s.removeElements(new ListNode(1), 1));
    }

}
