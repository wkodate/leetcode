package com.wkodate.leetcode.LC0083_RemoveDuplicatesFromSortedList;

import com.wkodate.leetcode.ListNode;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
    }

}
