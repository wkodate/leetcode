package com.wkodate.leetcode.LC0430_FlattenAMultilevelDoublyLinkedList;

public class Solution {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

        public Node(int val) {
            this.val = val;
        }
    }

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node current = head;
        while (current != null) {
            if (current.child == null) {
                current = current.next;
                continue;
            }

            Node child = current.child;
            while (child.next != null) {
                child = child.next;
            }

            child.next = current.next;
            if (current.next != null) {
                current.next.prev = child;
            }

            current.next = current.child;
            current.child.prev = current;
            current.child = null;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        node11.next = node12;
        node12.prev = node11;

        Node node7 = new Node(7);
        Node node8 = new Node(8);
        node8.child = node11;
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        node7.next = node8;
        node8.prev = node7;
        node8.next = node9;
        node9.prev = node8;
        node9.next = node10;
        node10.prev = node9;

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node3.child = node7;
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;

        System.out.println(s.flatten(node1));
    }

}
