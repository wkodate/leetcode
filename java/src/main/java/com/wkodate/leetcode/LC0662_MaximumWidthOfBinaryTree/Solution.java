package com.wkodate.leetcode.LC0662_MaximumWidthOfBinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    public class TreeNodeIdx {
        TreeNode node;
        int idx;

        public TreeNodeIdx(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNodeIdx> queue = new ArrayDeque<>();
        queue.add(new TreeNodeIdx(root, 0));
        int max = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int left = -1;
            int right = -1;
            for (int i = 0; i < size; i++) {
                TreeNodeIdx node = queue.poll();
                if (node.node.left != null) {
                    int idx = node.idx;
                    if (left == -1) {
                        left = 2 * idx;
                    } else {
                        right = 2 * idx;
                    }
                    queue.add(new TreeNodeIdx(node.node.left, 2 * idx));
                }
                if (node.node.right != null) {
                    int idx = node.idx;
                    if (left == -1) {
                        left = 2 * idx + 1;
                    } else {
                        right = 2 * idx + 1;
                    }
                    queue.add(new TreeNodeIdx(node.node.right, 2 * idx + 1));
                }
            }
            if (left != -1 && right != -1) {
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // 3
        TreeNode tn00_6 = new TreeNode(2);
        TreeNode tn10_6 = new TreeNode(1);
        TreeNode tn11_6 = new TreeNode(4);
        tn10_6.left = new TreeNode(3);
        tn11_6.left = new TreeNode(5);
        tn00_6.left = tn10_6;
        tn00_6.right = tn11_6;
        System.out.println(s.widthOfBinaryTree(tn00_6));

        // 1
        TreeNode tn00_5 = new TreeNode(1);
        tn00_5.right = new TreeNode(2);
        System.out.println(s.widthOfBinaryTree(tn00_5));

        // 4
        TreeNode tn00 = new TreeNode(1);
        TreeNode tn10 = new TreeNode(3);
        tn10.left = new TreeNode(5);
        tn10.right = new TreeNode(3);
        TreeNode tn11 = new TreeNode(2);
        tn11.right = new TreeNode(9);
        tn00.left = tn10;
        tn00.right = tn11;
        System.out.println(s.widthOfBinaryTree(tn00));

        // 2
        TreeNode tn00_2 = new TreeNode(1);
        TreeNode tn10_2 = new TreeNode(3);
        tn10_2.left = new TreeNode(5);
        tn10_2.right = new TreeNode(3);
        tn00_2.left = tn10_2;
        System.out.println(s.widthOfBinaryTree(tn00_2));

        // 2
        TreeNode tn00_3 = new TreeNode(1);
        TreeNode tn10_3 = new TreeNode(3);
        tn10_3.left = new TreeNode(5);
        tn00_3.left = tn10_3;
        tn00_3.right = new TreeNode(2);
        System.out.println(s.widthOfBinaryTree(tn00_3));

        // 8
        TreeNode tn00_4 = new TreeNode(1);
        TreeNode tn10_4 = new TreeNode(3);
        TreeNode tn11_4 = new TreeNode(2);
        TreeNode tn20_4 = new TreeNode(5);
        TreeNode tn23_4 = new TreeNode(9);
        tn20_4.left = new TreeNode(6);
        tn23_4.right = new TreeNode(7);
        tn10_4.left = tn20_4;
        tn11_4.right = tn23_4;
        tn00_4.left = tn10_4;
        tn00_4.right = tn11_4;
        System.out.println(s.widthOfBinaryTree(tn00_4));

    }

}
