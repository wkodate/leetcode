package com.wkodate.leetcode.LC0107_BinaryTreeLevelOrderTraversalII;

import com.wkodate.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Solution {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> polledNodes = new ArrayList<>();
            List<Integer> nodeValues = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                polledNodes.add(node);
                nodeValues.add(node.val);
            }
            ans.add(nodeValues);

            for (TreeNode node : polledNodes) {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode p0 = new TreeNode(3);
        TreeNode p10 = new TreeNode(9);
        TreeNode p11 = new TreeNode(20);
        TreeNode p22 = new TreeNode(15);
        TreeNode p23 = new TreeNode(7);
        p11.left = p22;
        p11.right = p23;
        p0.left = p10;
        p0.right = p11;
        // [[15,7],[9,20],[3]]
        System.out.println(s.levelOrderBottom(p0).toString());
        System.out.println(s.levelOrderBottom(null).toString());
    }


}
