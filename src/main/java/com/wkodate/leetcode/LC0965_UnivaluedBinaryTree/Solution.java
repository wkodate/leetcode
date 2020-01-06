package com.wkodate.leetcode.LC0965_UnivaluedBinaryTree;

import com.wkodate.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public boolean isUnivalTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        int val = root.val;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.val != val) {
                return false;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tn00 = new TreeNode(1);
        TreeNode tn10 = new TreeNode(1);
        tn10.left = new TreeNode(1);
        tn10.right = new TreeNode(1);
        TreeNode tn11 = new TreeNode(1);
        tn11.left = new TreeNode(1);
        tn11.right = new TreeNode(1);
        tn00.left = tn10;
        tn00.right = tn11;
        // true
        System.out.println(s.isUnivalTree(tn00));

        // false
        tn00.right = new TreeNode(2);
        System.out.println(s.isUnivalTree(tn00));
    }

}
