package com.wkodate.leetcode.LC0234_PalindromeLinkedList;

import com.wkodate.leetcode.ListNode;

public class Solution {

    public boolean isPalindrome(ListNode head) {
        // find middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode middle = slow;

        // reverse
        ListNode reverseHead = reverse(middle);

        // compare
        while (reverseHead != null) {
            if (head.val != reverseHead.val) {
                return false;
            }
            head = head.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l14 = new ListNode(5);
        ListNode l13 = new ListNode(4);
        l13.next = l14;
        ListNode l12 = new ListNode(3);
        l12.next = l13;
        ListNode l11 = new ListNode(2);
        l11.next = l12;
        ListNode l10 = new ListNode(1);
        l10.next = l11;
        System.out.println(solution.isPalindrome(l10));

        ListNode l21 = new ListNode(2);
        ListNode l20 = new ListNode(1);
        l20.next = l21;
        System.out.println(solution.isPalindrome(l20));

        ListNode l33 = new ListNode(1);
        ListNode l32 = new ListNode(2);
        l32.next = l33;
        ListNode l31 = new ListNode(2);
        l31.next = l32;
        ListNode l30 = new ListNode(1);
        l30.next = l31;
        System.out.println(solution.isPalindrome(l30));

        ListNode l44 = new ListNode(1);
        ListNode l43 = new ListNode(2);
        l43.next = l44;
        ListNode l42 = new ListNode(3);
        l42.next = l43;
        ListNode l41 = new ListNode(2);
        l41.next = l42;
        ListNode l40 = new ListNode(1);
        l40.next = l41;
        System.out.println(solution.isPalindrome(l40));
    }

}
