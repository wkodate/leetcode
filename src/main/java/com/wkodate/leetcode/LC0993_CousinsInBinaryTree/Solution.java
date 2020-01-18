package com.wkodate.leetcode.LC0993_CousinsInBinaryTree;

import com.wkodate.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    Map<Integer, Integer> depth;
    Map<Integer, TreeNode> parent;

    public void dfs(TreeNode node, TreeNode par) {
        if (node == null) {
            return;
        }
        if (par == null) {
            depth.put(node.val, 0);
        } else {
            depth.put(node.val, 1 + depth.get(par.val));
        }
        parent.put(node.val, par);
        dfs(node.left, node);
        dfs(node.right, node);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap<>();
        parent = new HashMap<>();
        dfs(root, null);
        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tn00 = new TreeNode(1);
        TreeNode tn10 = new TreeNode(2);
        tn10.left = new TreeNode(4);
        tn00.left = tn10;
        tn00.right = new TreeNode(3);
        System.out.println(s.isCousins(tn00, 4, 3));
    }

}
