package com.wkodate.leetcode.LC0203_RemoveLinkedListElements;

import com.wkodate.leetcode.ListNode;

public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode node = head;
        ListNode prev = preHead;
        while (node != null) {
            if (node.val == val) {
                prev.next = node.next;
            } else {
                prev = node;
            }
            node = node.next;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // null
        ListNode ln3 = ListNode.fromArray(new int[] { 1, 1 });
        System.out.println(s.removeElements(ln3, 1));
        // 1->2->3->4->5
        ListNode ln = ListNode.fromArray(new int[] { 1, 2, 6, 3, 4, 5, 6 });
        System.out.println(s.removeElements(ln, 6));
        // null
        System.out.println(s.removeElements(null, 0));
        // 2->3
        ListNode ln2 = ListNode.fromArray(new int[] { 1, 2, 3 });
        System.out.println(s.removeElements(ln2, 1));
        // null
        System.out.println(s.removeElements(new ListNode(1), 1));
    }

}
