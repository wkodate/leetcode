package com.wkodate.leetcode.LC0142_LinkedListCycleII;

import com.wkodate.leetcode.ListNode;

public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (slow != head) {
                    slow = slow.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.detectCycle(ListNode.fromArray(new int[]{3, 2, 0, -4})));
        System.out.println(s.detectCycle(ListNode.fromArray(new int[]{1, 2})));
    }

}
