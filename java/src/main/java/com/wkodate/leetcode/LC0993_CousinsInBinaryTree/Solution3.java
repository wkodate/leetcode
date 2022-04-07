package com.wkodate.leetcode.LC0993_CousinsInBinaryTree;

import com.wkodate.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3 {

    class CustomTreeNode {
        TreeNode node;
        TreeNode parent;

        public CustomTreeNode(TreeNode tn, TreeNode ptn) {
            node = tn;
            parent = ptn;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<CustomTreeNode> queue = new ArrayDeque<>();
        CustomTreeNode tnp = new CustomTreeNode(root, null);
        queue.add(tnp);
        while (!queue.isEmpty()) {
            int size = queue.size();
            CustomTreeNode xnode = null;
            CustomTreeNode ynode = null;
            for (int i = 0; i < size; i++) {
                CustomTreeNode cn = queue.poll();
                if (cn.node.val == x) {
                    xnode = cn;
                }
                if (cn.node.val == y) {
                    ynode = cn;
                }
                if (cn.node.left != null) {
                    queue.add(new CustomTreeNode(cn.node.left, cn.node));
                }
                if (cn.node.right != null) {
                    queue.add(new CustomTreeNode(cn.node.right, cn.node));
                }
            }
            if (xnode != null && ynode != null && xnode.parent.val != ynode.parent.val) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();

        // true
        TreeNode tn00_2 = new TreeNode(1);
        TreeNode tn10_2 = new TreeNode(2);
        TreeNode tn11_2 = new TreeNode(3);
        tn10_2.right = new TreeNode(5);
        tn11_2.right = new TreeNode(4);
        tn00_2.left = tn10_2;
        tn00_2.right = tn11_2;
        System.out.println(s.isCousins(tn00_2, 5, 4));

        // false
        TreeNode tn00 = new TreeNode(1);
        TreeNode tn10 = new TreeNode(2);
        tn10.left = new TreeNode(4);
        tn00.left = tn10;
        tn00.right = new TreeNode(3);
        System.out.println(s.isCousins(tn00, 4, 3));

        //false
        TreeNode tn00_3 = new TreeNode(1);
        TreeNode tn10_3 = new TreeNode(2);
        tn10_3.right = new TreeNode(4);
        tn00_3.left = tn10_3;
        tn00_3.right = new TreeNode(3);
        System.out.println(s.isCousins(tn00_3, 2, 3));
    }

}
