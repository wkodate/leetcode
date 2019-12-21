package com.wkodate.leetcode.LC0160_IntersectionOfTwoLinkedLists;

import com.wkodate.leetcode.ListNode;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            if (nodeA == null) {
                nodeA = headB;
            } else {
                nodeA = nodeA.next;
            }
            if (nodeB == null) {
                nodeB = headA;
            } else {
                nodeB = nodeB.next;
            }
        }
        return nodeA;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node1 = ListNode.generate(new int[]{4, 1, 8, 4, 5});
        ListNode node2 = ListNode.generate(new int[]{5, 0, 1, 8, 4, 5});
        System.out.println(s.getIntersectionNode(node1, node2));
    }

}
