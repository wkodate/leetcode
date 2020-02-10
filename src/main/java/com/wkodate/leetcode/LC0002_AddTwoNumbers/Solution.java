package com.wkodate.leetcode.LC0002_AddTwoNumbers;

import com.wkodate.leetcode.ListNode;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ansHead = new ListNode(0);
        ListNode current = ansHead;
        while (l1 != null || l2 != null) {
            int l1val = 0;
            int l2val = 0;
            if (l1 != null) {
                l1val = l1.val;
            }
            if (l2 != null) {
                l2val = l2.val;
            }
            int s = l1val + l2val + carry;
            carry = 0;
            if (s / 10 >= 1) {
                carry = 1;
            }
            int sum = s % 10;
            int r = sum % 10;
            current.next = new ListNode(r);
            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry >= 1) {
            current.next = new ListNode(carry);
        }
        return ansHead.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7,0,8
        System.out.println(s.addTwoNumbers(ListNode.fromArray(new int[]{2, 4, 3}), ListNode.fromArray(new int[]{5, 6, 4})));
        // 0
        System.out.println(s.addTwoNumbers(ListNode.fromArray(new int[]{0}), ListNode.fromArray(new int[]{0})));
        // 0,1
        System.out.println(s.addTwoNumbers(ListNode.fromArray(new int[]{5}), ListNode.fromArray(new int[]{5})));
        // 1,8
        System.out.println(s.addTwoNumbers(ListNode.fromArray(new int[]{1, 8}), ListNode.fromArray(new int[]{0})));
        // 0,0,0,0,0,0,0,0,0,0,1
        System.out.println(s.addTwoNumbers(ListNode.fromArray(new int[]{9}), ListNode.fromArray(new int[]{1, 9, 9, 9, 9, 9, 9, 9, 9, 9})));
    }

}
