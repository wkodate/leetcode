package com.wkodate.leetcode.LC0133_CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    private Map<Integer, Node> map = new HashMap<>();

    public Node clone(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(newNode.val, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(clone(neighbor));
        }
        return newNode;
    }

    public Node cloneGraph(Node node) {
        return clone(node);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        List<Node> neighbors1 = new ArrayList<>();
        neighbors1.add(node2);
        neighbors1.add(node4);
        node1.neighbors = neighbors1;
        List<Node> neighbors2 = new ArrayList<>();
        neighbors2.add(node1);
        neighbors2.add(node3);
        node2.neighbors = neighbors2;
        List<Node> neighbors3 = new ArrayList<>();
        neighbors3.add(node2);
        neighbors3.add(node4);
        node3.neighbors = neighbors3;
        List<Node> neighbors4 = new ArrayList<>();
        neighbors4.add(node1);
        neighbors4.add(node3);
        node4.neighbors = neighbors4;
        System.out.println(s.cloneGraph(node1));
    }

}
