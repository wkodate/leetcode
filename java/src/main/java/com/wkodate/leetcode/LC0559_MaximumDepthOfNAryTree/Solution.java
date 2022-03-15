package com.wkodate.leetcode.LC0559_MaximumDepthOfNAryTree;

import com.wkodate.leetcode.Node;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int max = 0;

    public int maxDepth(Node root, int depth) {
        if (root == null || root.children == null || root.children.size() == 0) {
            return depth;
        }
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child, depth + 1));
        }
        return max;
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return maxDepth(root, 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Node> children10 = new ArrayList<>();
        children10.add(new Node(5));
        children10.add(new Node(6));
        Node n10 = new Node(3, children10);
        List<Node> children00 = new ArrayList<>();
        children00.add(n10);
        children00.add(new Node(2));
        children00.add(new Node(4));
        Node n00 = new Node(1, children00);
        // 3
        System.out.println(s.maxDepth(n00));
        // 0
        System.out.println(s.maxDepth(null));
    }

}
