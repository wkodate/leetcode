package com.wkodate.leetcode.LC0700_SearchInABinarySearchTree;

import com.wkodate.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val == val) {
                return node;
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tn00 = new TreeNode(4);
        TreeNode tn10 = new TreeNode(2);
        tn10.left = new TreeNode(1);
        tn10.right = new TreeNode(3);
        tn00.left = tn10;
        tn00.right = new TreeNode(7);
        System.out.println(s.searchBST(tn00, 2));
    }

}
