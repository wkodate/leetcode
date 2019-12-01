package com.wkodate.leetcode.LC0206_ReverseLinkedList;

public class Solution {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode tmp = current.next;
            // currentのnextにprevを入れて反転させたnodeをprevにする
            current.next = prev;
            prev = current;
            // currentに元のcurrent.nextを入れる
            current = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
    }

}
