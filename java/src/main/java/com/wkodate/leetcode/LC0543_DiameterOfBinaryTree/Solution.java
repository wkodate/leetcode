package com.wkodate.leetcode.LC0543_DiameterOfBinaryTree;

import com.wkodate.leetcode.TreeNode;

public class Solution {
    int maxLength = 1;

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = depth(node.left);
        int r = depth(node.right);
        maxLength = Math.max(maxLength, l + r + 1);
        return Math.max(l, r) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxLength - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tn00 = new TreeNode(1);
        TreeNode tn10 = new TreeNode(2);
        TreeNode tn11 = new TreeNode(3);
        TreeNode tn20 = new TreeNode(4);
        TreeNode tn21 = new TreeNode(5);
        tn10.left = tn20;
        tn10.right = tn21;
        tn00.left = tn10;
        tn00.right = tn11;
        System.out.println(s.diameterOfBinaryTree(tn00));
    }

}
