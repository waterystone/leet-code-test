package com.adu.leet_code.problems.algorithms.n0101;

import com.adu.leet_code.problems.model.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * @author yunjie.du
 * @date 2017/8/15 15:46
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/description/">104. Maximum Depth of Binary
 *      Tree</a>
 */
public class N0104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
