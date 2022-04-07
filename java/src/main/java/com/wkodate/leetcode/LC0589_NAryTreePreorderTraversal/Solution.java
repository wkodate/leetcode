package com.wkodate.leetcode.LC0589_NAryTreePreorderTraversal;

import com.wkodate.leetcode.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

}
