package com.wkodate.leetcode.LC0237_DeleteNodeInALinkedList;

import com.wkodate.leetcode.ListNode;

public class Solution {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

}
