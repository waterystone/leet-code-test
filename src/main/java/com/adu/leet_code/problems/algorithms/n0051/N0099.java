package com.adu.leet_code.problems.algorithms.n0051;

import com.adu.leet_code.problems.model.TreeNode;

/**
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * 
 * @author yunjie.du
 * @date 2017/8/15 10:46
 * @see <a href="https://leetcode.com/problems/recover-binary-search-tree/description/">99. Recover Binary Search
 *      Tree</a>
 */
public class N0099 {
    public void recoverTree(TreeNode root) {
        TreeNode[] prevNodes = new TreeNode[2];
        recoverTree(root, prevNodes);
    }

    private void recoverTree(TreeNode root, TreeNode[] prevNodes) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.left.val >= root.val) {
                if (prevNodes[0] == null) {
                    prevNodes[0] = root;
                    prevNodes[1] = root.left;
                } else {
                    recover(prevNodes[0], prevNodes[1], root, root.left);
                    return;
                }
            } else {
                recoverTree(root.left, prevNodes);
            }
        }

        if (root.right != null) {
            if (root.right.val <= root.val) {
                if (prevNodes[0] == null) {
                    prevNodes[0] = root;
                    prevNodes[1] = root.right;
                } else {
                    recover(prevNodes[0], prevNodes[1], root, root.right);
                    return;
                }
            } else {
                recoverTree(root.right, prevNodes);
            }
        }
    }

    private void recover(TreeNode prevParent, TreeNode prevNode, TreeNode root, TreeNode child) {
        boolean isPrevLeft = prevParent.left == prevNode ? true : false, isLeft = root.left == child ? true : false;
        if (isPrevLeft) {
            prevParent.left = child;
        } else {
            prevParent.right = child;
        }

        if (isLeft) {
            root.left = prevNode;
        } else {
            root.right = prevNode;
        }
    }
}
