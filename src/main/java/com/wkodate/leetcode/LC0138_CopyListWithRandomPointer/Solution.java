package com.wkodate.leetcode.LC0138_CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            int rand = -1;
            if (random != null) {
                rand = random.val;
            }
            return "Node{" +
                    "val=" + val +
                    ", random=" + rand +
                    ", next=" + next +
                    '}';
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // copy all nodes.
        Map<Node, Node> map = new HashMap<>();
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        // assign next and random pointer.
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        node0.random = null;
        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(s.copyRandomList(node0));
    }

}
