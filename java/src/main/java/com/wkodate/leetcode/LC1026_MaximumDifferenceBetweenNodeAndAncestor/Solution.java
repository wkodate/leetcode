package com.wkodate.leetcode.LC1026_MaximumDifferenceBetweenNodeAndAncestor;

import com.wkodate.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    int maxDiff;

    private void ancestorDiff(TreeNode root, List<Integer> parents) {
        for (int i = 0; i < parents.size(); i++) {
            maxDiff = Math.max(Math.abs(root.val - parents.get(i)), maxDiff);
        }
        if (root.left == null && root.right == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < parents.size(); i++) {
            list.add(parents.get(i));
        }
        list.add(root.val);
        if (root.left != null) {
            ancestorDiff(root.left, list);
        }
        if (root.right != null) {
            ancestorDiff(root.right, list);
        }
    }

    public int maxAncestorDiff(TreeNode root) {
        maxDiff = 0;
        List<Integer> parents = new ArrayList<>();
        ancestorDiff(root, parents);
        return maxDiff;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode n21 = new TreeNode(6);
        n21.left = new TreeNode(4);
        n21.right = new TreeNode(7);

        TreeNode n23 = new TreeNode(6);
        n23.left = new TreeNode(13);

        TreeNode n10 = new TreeNode(3);
        n10.left = new TreeNode(1);
        n10.right = n21;

        TreeNode n11 = new TreeNode(10);
        n11.right = n23;

        TreeNode n00 = new TreeNode(8);
        n00.left = n10;
        n00.right = n11;
        // 7
        System.out.println(s.maxAncestorDiff(n00));
    }

}
