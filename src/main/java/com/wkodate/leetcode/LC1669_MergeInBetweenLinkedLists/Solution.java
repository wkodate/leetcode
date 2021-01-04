package com.wkodate.leetcode.LC1669_MergeInBetweenLinkedLists;

import com.wkodate.leetcode.ListNode;

public class Solution {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        for (int i = 0; i < a - 1; i++) {
            list1 = list1.next;
        }
        ListNode list1Tail = list1;
        for (int i = 0; i < b - a + 1; i++) {
            list1Tail = list1Tail.next;
        }
        list1.next = list2;
        while (list1.next != null) {
            list1 = list1.next;
        }
        list1.next = list1Tail.next;
        return head;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // 0, 1, 2, 1000000, 1000001, 1000002, 5
        System.out.println(s.mergeInBetween(
                ListNode.fromArray(new int[]{0, 1, 2, 3, 4, 5}),
                3,
                4,
                ListNode.fromArray(new int[]{1000000, 1000001, 1000002})
        ));
        // [0,1,1000000,1000001,1000002,1000003,1000004,6]
        System.out.println(s.mergeInBetween(
                ListNode.fromArray(new int[]{0, 1, 2, 3, 4, 5, 6}),
                2,
                5,
                ListNode.fromArray(new int[]{1000000, 1000001, 1000002, 1000003, 1000004})
        ));
        // 0,3,2,1000000,1000001,1000002,5
        System.out.println(s.mergeInBetween(
                ListNode.fromArray(new int[]{0, 3, 2, 1, 4, 5}),
                3,
                4,
                ListNode.fromArray(new int[]{1000000, 1000001, 1000002})
        ));
    }

}
