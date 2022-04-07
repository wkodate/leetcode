package com.wkodate.leetcode.LC0652_FindDuplicateSubtrees;

import com.wkodate.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    Map<String, Integer> count;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        ans = new ArrayList<>();
        collect(root);
        return ans;
    }

    public String collect(TreeNode node) {
        if (node == null) {
            return "#";
        }
        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2) {
            ans.add(node);
        }
        return serial;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tn00 = new TreeNode(1);
        TreeNode tn11 = new TreeNode(3);
        tn11.left = new TreeNode(4);
        tn11.right = new TreeNode(5);
        tn00.left = new TreeNode(2);
        tn00.right = tn11;
        System.out.println(s.findDuplicateSubtrees(tn00));
    }

}
