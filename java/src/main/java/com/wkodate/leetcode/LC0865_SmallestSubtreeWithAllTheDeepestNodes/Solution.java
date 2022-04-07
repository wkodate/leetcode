package com.wkodate.leetcode.LC0865_SmallestSubtreeWithAllTheDeepestNodes;

import com.wkodate.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<TreeNode, Integer> depth;
    private int max_depth;

    public void dfs(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        depth.put(node, depth.get(parent) + 1);
        dfs(node.left, node);
        dfs(node.right, node);
    }

    public TreeNode subtree(TreeNode node) {
        if (node == null || depth.get(node) == max_depth) {
            return node;
        }
        TreeNode leftNode = subtree(node.left);
        TreeNode rightNode = subtree(node.right);
        if (leftNode != null) {
            return leftNode;
        }
        if (rightNode != null) {
            return rightNode;
        }
        return null;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth = new HashMap<>();
        depth.put(null, -1);
        dfs(root, null);
        max_depth = -1;
        for (Integer d : depth.values()) {
            max_depth = Math.max(max_depth, d);
        }
        return subtree(root);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }

}
