package com.wkodate.leetcode.LC0897_IncreasingOrderSearchTree;

import com.wkodate.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) {
            return;
        }
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        TreeNode ans = new TreeNode(0);
        TreeNode cur = ans;
        for (int val : list) {
            cur.right = new TreeNode(val);
            cur = cur.right;
        }
        return ans.right;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
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
