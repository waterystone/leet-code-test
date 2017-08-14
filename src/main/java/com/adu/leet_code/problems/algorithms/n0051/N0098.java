package com.adu.leet_code.problems.algorithms.n0051;

import java.util.ArrayList;
import java.util.List;

import com.adu.leet_code.problems.model.TreeNode;

/**
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * <pre>
 Example 1:
 2
 / \
 1   3
 Binary tree [2,1,3], return true.
 * </pre>
 * 
 * <pre>
 Example 2:
 1
 / \
 2   3
 Binary tree [1,2,3], return false.
 * </pre>
 *
 * @author yunjie.du
 * @date 2017/8/14 17:47
 * @see <a href="https://leetcode.com/problems/validate-binary-search-tree/description/">98. Validate Binary Search
 *      Tree</a>
 */
public class N0098 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }

        if (root.val >= maxValue || root.val <= minValue) {
            return false;
        }

        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }

    /**
     * 思想：中序遍历，判断是否有序。
     * 
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraverse(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    private void inorderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorderTraverse(root.left, list);
        list.add(root.val);
        inorderTraverse(root.right, list);
    }

}
