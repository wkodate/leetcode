package com.wkodate.leetcode.LC0669_TrimABinarySearchTree;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return root;
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }

}
