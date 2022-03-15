package com.wkodate.leetcode.LC0094_BinaryTreeInorderTraversal;

import com.wkodate.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            ans.add(current.val);
            current = current.right;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        TreeNode tn22 = new TreeNode(3);
        TreeNode tn11 = new TreeNode(2);
        tn11.left = tn22;
        TreeNode tn00 = new TreeNode(1);
        tn00.right = tn11;
        // 1,3,2
        System.out.println(s.inorderTraversal(tn00));
    }

}
