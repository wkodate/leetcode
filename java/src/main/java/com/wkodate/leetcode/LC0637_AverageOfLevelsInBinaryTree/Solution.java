package com.wkodate.leetcode.LC0637_AverageOfLevelsInBinaryTree;

import com.wkodate.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> children = new ArrayList<>();
            long sum = 0;
            while (!queue.isEmpty()) {
                TreeNode childNode = queue.remove();
                sum += childNode.val;
                children.add(childNode);
            }
            ans.add((double) sum / children.size());
            for (TreeNode child : children) {
                if (child.left != null) {
                    queue.add(child.left);
                }
                if (child.right != null) {
                    queue.add(child.right);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tn00 = new TreeNode(3);
        tn00.left = new TreeNode(9);
        TreeNode tn11 = new TreeNode(20);
        tn11.left = new TreeNode(15);
        tn11.right = new TreeNode(7);
        tn00.right = tn11;
        System.out.println(s.averageOfLevels(tn00).toString());
    }

}
