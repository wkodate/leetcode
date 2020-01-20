package com.wkodate.leetcode.LC0257_BinaryTreePaths;

import com.wkodate.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private void searchBT(TreeNode root, String path, List<String> ans) {
        if (root.left == null && root.right == null) {
            ans.add(path + root.val);
        }
        if (root.left != null) {
            searchBT(root.left, path + root.val + "->", ans);
        }
        if (root.right != null) {
            searchBT(root.right, path + root.val + "->", ans);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root != null) {
            searchBT(root, "", ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }

}
