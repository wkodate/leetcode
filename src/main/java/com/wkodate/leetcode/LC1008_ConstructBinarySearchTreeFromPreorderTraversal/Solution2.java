package com.wkodate.leetcode.LC1008_ConstructBinarySearchTreeFromPreorderTraversal;

import com.wkodate.leetcode.TreeNode;

public class Solution2 {

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode head = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = head;
            while (true) {
                if (preorder[i] < node.val) {
                    if (node.left != null) {
                        node = node.left;
                    } else {
                        node.left = new TreeNode(preorder[i]);
                        break;
                    }
                } else {
                    if (node.right != null) {
                        node = node.right;
                    } else {
                        node.right = new TreeNode(preorder[i]);
                        break;
                    }
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.bstFromPreorder(new int[] { 8, 5, 1, 7, 10, 12 }));
    }

}
