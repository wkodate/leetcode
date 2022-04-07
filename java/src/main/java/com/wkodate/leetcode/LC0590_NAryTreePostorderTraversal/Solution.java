package com.wkodate.leetcode.LC0590_NAryTreePostorderTraversal;

import com.wkodate.leetcode.Node;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return list;
        }
        for (Node node : root.children) {
            postorder(node);
        }
        list.add(root.val);
        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }

}
