package com.wkodate.leetcode.LC0104_MaximumDepthOfBinaryTree;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
    }

}
