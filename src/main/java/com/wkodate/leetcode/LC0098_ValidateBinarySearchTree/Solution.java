package com.wkodate.leetcode.LC0098_ValidateBinarySearchTree;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    private boolean isValid(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (min != null && val <= min) {
            return false;
        }
        if (max != null && val >= max) {
            return false;
        }

        if (!isValid(node.left, min, val)) {
            return false;
        }
        if (!isValid(node.right, val, max)) {
            return false;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        TreeNode tn00 = new TreeNode(2);
        tn00.left = new TreeNode(1);
        tn00.right = new TreeNode(3);
        System.out.println(s.isValidBST(tn00));

        // false
        TreeNode tn11_2 = new TreeNode(4);
        tn11_2.left = new TreeNode(3);
        tn11_2.right = new TreeNode(6);
        TreeNode tn00_2 = new TreeNode(5);
        tn00_2.left = new TreeNode(1);
        tn00_2.right = tn11_2;
        System.out.println(s.isValidBST(tn00_2));

        // false
        TreeNode tn11_3 = new TreeNode(15);
        tn11_3.left = new TreeNode(6);
        tn11_3.right = new TreeNode(20);
        TreeNode tn00_3 = new TreeNode(10);
        tn00_3.left = new TreeNode(5);
        tn00_3.right = tn11_3;
        System.out.println(s.isValidBST(tn00_3));
    }

}
