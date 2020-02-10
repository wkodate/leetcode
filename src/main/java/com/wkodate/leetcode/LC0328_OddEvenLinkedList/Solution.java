package com.wkodate.leetcode.LC0328_OddEvenLinkedList;

import com.wkodate.leetcode.ListNode;

public class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
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
        Solution s = new Solution();
        // 1,3,5,2,4
        System.out.println(s.oddEvenList(ListNode.fromArray(new int[]{1, 2, 3, 4, 5})));
        // 2,3,6,7,1,5,4
        System.out.println(s.oddEvenList(ListNode.fromArray(new int[]{2, 1, 3, 5, 6, 4, 7})));
        // 1,3,5,7,2,4,6,8
        System.out.println(s.oddEvenList(ListNode.fromArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8})));
    }

}
