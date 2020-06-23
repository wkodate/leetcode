package com.wkodate.leetcode.LC0222_CountCompleteTreeNodes;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    private int countChildren(TreeNode root) {
        int cnt = 1;
        if (root.left != null) {
            cnt += countChildren(root.left);
        }
        if (root.right != null) {
            cnt += countChildren(root.right);
        }
        return cnt;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countChildren(root);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        TreeNode tn10 = new TreeNode(2);
        tn10.left = new TreeNode(4);
        tn10.right = new TreeNode(5);
        TreeNode tn11 = new TreeNode(3);
        tn11.left = new TreeNode(6);
        TreeNode tn00 = new TreeNode(1);
        tn00.left = tn10;
        tn00.right = tn11;
        System.out.println(s.countNodes(tn00));
    }

}
