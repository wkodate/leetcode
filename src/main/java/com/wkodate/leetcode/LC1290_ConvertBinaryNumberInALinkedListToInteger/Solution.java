package com.wkodate.leetcode.LC1290_ConvertBinaryNumberInALinkedListToInteger;

import com.wkodate.leetcode.ListNode;

public class Solution {

    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.getDecimalValue(ListNode.fromArray(new int[]{1, 0, 1})));
        // 0
        System.out.println(s.getDecimalValue(ListNode.fromArray(new int[]{0})));
        // 1
        System.out.println(s.getDecimalValue(ListNode.fromArray(new int[]{1})));
        // 18880
        System.out.println(s.getDecimalValue(ListNode.fromArray(new int[]{1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0})));
        // 0
        System.out.println(s.getDecimalValue(ListNode.fromArray(new int[]{0, 0})));
    }

}
