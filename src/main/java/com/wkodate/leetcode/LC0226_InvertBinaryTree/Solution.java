package com.wkodate.leetcode.LC0226_InvertBinaryTree;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode n20 = new TreeNode(1);
        TreeNode n21 = new TreeNode(3);
        TreeNode n22 = new TreeNode(6);
        TreeNode n23 = new TreeNode(9);
        TreeNode n10 = new TreeNode(2);
        n10.left = n20;
        n10.right = n21;
        TreeNode n11 = new TreeNode(7);
        n11.left = n22;
        n11.right = n23;
        TreeNode n0 = new TreeNode(4);
        n0.left = n10;
        n0.right = n11;
        System.out.println(solution.invertTree(n0));
    }

}
