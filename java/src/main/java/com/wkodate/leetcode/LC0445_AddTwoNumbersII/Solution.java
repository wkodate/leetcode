package com.wkodate.leetcode.LC0445_AddTwoNumbersII;

import com.wkodate.leetcode.ListNode;

public class Solution {

    private String toNumString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            node = node.next;
        }
        return sb.toString();
    }

    private String addTwoStringNumbers(String str1, String str2) {
        str1 = new StringBuilder(str1).reverse().toString();
        str2 = new StringBuilder(str2).reverse().toString();
        StringBuilder sum = new StringBuilder();
        int increment = 0;
        for (int i = 0; i < Math.max(str1.length(), str2.length()); i++) {
            if (i >= str1.length()) {
                int num2 = str2.charAt(i) - '0';
                if (num2 + increment >= 10) {
                    sum.append((num2 + increment) % 10);
                } else {
                    sum.append(num2 + increment);
                    increment = 0;
                }
            } else if (i >= str2.length()) {
                int num1 = str1.charAt(i) - '0';
                if (num1 + increment >= 10) {
                    sum.append((num1 + increment) % 10);
                } else {
                    sum.append(num1 + increment);
                    increment = 0;
                }
            } else {
                int num1 = str1.charAt(i) - '0';
                int num2 = str2.charAt(i) - '0';
                if (num1 + num2 + increment >= 10) {
                    sum.append((num1 + num2 + increment) % 10);
                    increment = 1;
                } else {
                    sum.append(num1 + num2 + increment);
                    increment = 0;
                }
            }
        }
        if (increment > 0) {
            sum.append(increment);
        }
        return sum.reverse().toString();
    }

    private ListNode toListNode(String num) {
        String numStr = String.valueOf(num);
        ListNode head = new ListNode(Integer.parseInt(numStr.substring(0, 1)));
        ListNode node = head;
        for (int i = 1; i < numStr.length(); i++) {
            node.next = new ListNode(Integer.parseInt(numStr.substring(i, i + 1)));
            node = node.next;
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String l1str = toNumString(l1);
        String l2str = toNumString(l2);
        String sum = addTwoStringNumbers(l1str, l2str);
        return toListNode(sum);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1 -> 9 -> 8
        System.out.println(s.addTwoNumbers(
                ListNode.fromArray(new int[]{9, 9}),
                ListNode.fromArray(new int[]{9, 9})));
        System.out.println(s.addTwoNumbers(
                ListNode.fromArray(new int[]{3, 9, 9, 9, 9, 9, 9, 9, 9, 9}),
                ListNode.fromArray(new int[]{7})));
        // 7 -> 8 -> 0 -> 7
        System.out.println(s.addTwoNumbers(
                ListNode.fromArray(new int[]{7, 2, 4, 3}),
                ListNode.fromArray(new int[]{5, 6, 4})));
    }

}
