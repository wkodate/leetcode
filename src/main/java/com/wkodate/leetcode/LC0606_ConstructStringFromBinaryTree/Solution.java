package com.wkodate.leetcode.LC0606_ConstructStringFromBinaryTree;

import com.wkodate.leetcode.TreeNode;

public class Solution {

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        if (t.left != null) {
            sb.append("(");
            sb.append(tree2str(t.left));
            sb.append(")");
        }
        if (t.right != null) {
            if (t.left == null) {
                sb.append("()");
            }
            sb.append("(");
            sb.append(tree2str(t.right));
            sb.append(")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1(2(4))(3)
        TreeNode tn00 = new TreeNode(1);
        TreeNode tn10 = new TreeNode(2);
        tn10.left = new TreeNode(4);
        tn00.left = tn10;
        tn00.right = new TreeNode(3);
        System.out.println(s.tree2str(tn00));

        // 1(2()(4))(3)
        TreeNode tn00_2 = new TreeNode(1);
        TreeNode tn10_2 = new TreeNode(2);
        tn10_2.right = new TreeNode(4);
        tn00_2.left = tn10_2;
        tn00_2.right = new TreeNode(3);
        System.out.println(s.tree2str(tn00_2));
    }

}
