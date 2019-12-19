package com.wkodate.leetcode.LC0617_MergeTwoBinaryTrees;

import com.wkodate.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        Deque<TreeNode[]> stack = new ArrayDeque<>();
        stack.push(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[]{t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[]{t[0].right, t[1].right});
            }
        }
        return t1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }

}
