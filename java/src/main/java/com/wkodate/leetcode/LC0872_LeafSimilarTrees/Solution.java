package com.wkodate.leetcode.LC0872_LeafSimilarTrees;

import com.wkodate.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public void dfs(TreeNode node, List<Integer> leafs) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leafs.add(node.val);
        }
        dfs(node.left, leafs);
        dfs(node.right, leafs);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        dfs(root1, leaf1);
        dfs(root2, leaf2);
        return leaf1.equals(leaf2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }

}
