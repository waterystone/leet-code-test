package com.adu.leet_code.problems.algorithms.n0101;

import com.adu.leet_code.problems.model.TreeNode;

/**
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * <pre>
 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 * </pre>
 * 
 * <pre>
 But the following [1,2,2,null,3,null,3] is not:
 1
 / \
 2   2
 \   \
 3    3
 * </pre>
 * 
 * Note: Bonus points if you could solve it both recursively and iteratively.
 *
 * @author yunjie.du
 * @date 2017/8/15 11:29
 * @see <a href="https://leetcode.com/problems/symmetric-tree/description/">101. Symmetric Tree</a>
 */
public class N0101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
