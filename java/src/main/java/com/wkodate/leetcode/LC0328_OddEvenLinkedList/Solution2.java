package com.wkodate.leetcode.LC0328_OddEvenLinkedList;

import com.wkodate.leetcode.ListNode;

public class Solution2 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = even.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // 1->3->5->2->4->NULL
        ListNode ln3 = new ListNode(4);
        ln3.next = new ListNode(5);
        ListNode ln2 = new ListNode(3);
        ln2.next = ln3;
        ListNode ln1 = new ListNode(2);
        ln1.next = ln2;
        ListNode ln0 = new ListNode(1);
        ln0.next = ln1;
        System.out.println(s.oddEvenList(ln0));

        // 2->3->6->7->1->5->4->NULL
        ListNode ln5_2 = new ListNode(4);
        ln5_2.next = new ListNode(7);
        ListNode ln4_2 = new ListNode(6);
        ln4_2.next = ln5_2;
        ListNode ln3_2 = new ListNode(5);
        ln3_2.next = ln4_2;
        ListNode ln2_2 = new ListNode(3);
        ln2_2.next = ln3_2;
        ListNode ln1_2 = new ListNode(1);
        ln1_2.next = ln2_2;
        ListNode ln0_2 = new ListNode(2);
        ln0_2.next = ln1_2;
        System.out.println(s.oddEvenList(ln0_2));
    }

}
