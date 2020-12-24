package com.wkodate.leetcode.LC0024_SwapNodesInPairs;

import com.wkodate.leetcode.ListNode;

public class Solution {

    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode prev = newHead;
        ListNode node = head;
        prev.next = node;
        while (node != null && node.next != null) {
            prev.next = node.next;
            ListNode tmp = node.next.next;
            node.next.next = node;
            node.next = tmp;
            prev = node;
            node = node.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //[2,1,4,3]
        System.out.println(s.swapPairs(ListNode.fromArray(new int[]{1, 2, 3, 4})));
        //[]
        System.out.println(s.swapPairs(ListNode.fromArray(new int[]{})));
        //[1]
        System.out.println(s.swapPairs(ListNode.fromArray(new int[]{1})));
    }

}
