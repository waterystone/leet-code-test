package com.adu.leet_code.problems.algorithms.n0051;

import com.adu.leet_code.problems.model.TreeNode;

/**
 *
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 * @author yunjie.du
 * @date 2017/8/15 11:20
 * @see <a href="https://leetcode.com/problems/same-tree/description/">100. Same Tree</a>
 */
public class N0100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
