package com.wkodate.leetcode.LC1008_ConstructBinarySearchTreeFromPreorderTraversal;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
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
        Solution s = new Solution();
        // [8,5,10,1,7,null,12]
        System.out.println(s.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
    }

}
