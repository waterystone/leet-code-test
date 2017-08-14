package com.adu.leet_code.problems.algorithms.n0051;

import java.util.ArrayList;
import java.util.List;

import com.adu.leet_code.problems.model.TreeNode;

/**
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * <pre>
 For example:
 Given binary tree [1,null,2,3],
 1
 \
 2
 /
 3
 return [1,3,2].
 * </pre>
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * @author yunjie.du
 * @date 2017/8/14 14:26
 * @see <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/description/">94. Binary Tree Inorder
 *      Traversal</a>
 */
public class N0094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);

        return res;
    }

    private void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }
}
