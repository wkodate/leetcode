package com.wkodate.leetcode.LC0021_MergeTwoSortedLists;

import com.wkodate.leetcode.ListNode;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode beforeHead = new ListNode(0);
        ListNode current = beforeHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 == null) {
            current.next = l2;
        } else {
            current.next = l1;
        }
        return beforeHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l12 = new ListNode(4);
        ListNode l11 = new ListNode(2);
        l11.next = l12;
        ListNode l10 = new ListNode(1);
        l10.next = l11;
        ListNode l22 = new ListNode(4);
        ListNode l21 = new ListNode(3);
        l21.next = l22;
        ListNode l20 = new ListNode(1);
        l20.next = l21;
        System.out.println(solution.mergeTwoLists(l10, l20));
    }

}
