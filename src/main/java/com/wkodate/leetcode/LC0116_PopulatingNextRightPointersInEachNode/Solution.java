package com.wkodate.leetcode.LC0116_PopulatingNextRightPointersInEachNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node head = root;
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i != size - 1) {
                    Node next = queue.peek();
                    node.next = next;
                }
                if (node.left == null) {
                    continue;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }

}
