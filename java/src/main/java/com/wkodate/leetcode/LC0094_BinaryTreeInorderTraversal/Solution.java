package com.wkodate.leetcode.LC0094_BinaryTreeInorderTraversal;

import com.wkodate.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return ans;
        }
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        ans.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tn22 = new TreeNode(3);
        TreeNode tn11 = new TreeNode(2);
        tn11.left = tn22;
        TreeNode tn00 = new TreeNode(1);
        tn00.right = tn11;
        // 1,3,2
        System.out.println(s.inorderTraversal(tn00));
    }

}
