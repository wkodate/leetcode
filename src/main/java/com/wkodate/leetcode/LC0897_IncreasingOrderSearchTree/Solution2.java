package com.wkodate.leetcode.LC0897_IncreasingOrderSearchTree;

import com.wkodate.leetcode.TreeNode;

public class Solution2 {

    TreeNode cur;

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        TreeNode tn20 = new TreeNode(2);
        tn20.left = new TreeNode(1);
        TreeNode tn10 = new TreeNode(3);
        tn10.left = tn20;
        tn10.right = new TreeNode(4);

        TreeNode tn23 = new TreeNode(8);
        tn23.left = new TreeNode(7);
        tn23.right = new TreeNode(9);
        TreeNode tn11 = new TreeNode(6);
        tn11.right = tn23;

        TreeNode tn00 = new TreeNode(5);
        tn00.left = tn10;
        tn00.right = tn11;
        System.out.println(s.increasingBST(tn00));
    }

}
