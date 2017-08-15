package com.adu.leet_code.problems.algorithms.n0101;

import java.util.ArrayList;
import java.util.List;

import com.adu.leet_code.problems.model.TreeNode;

/**
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * <pre>
 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]
 * </pre>
 *
 * @author yunjie.du
 * @date 2017/8/15 11:47
 * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/description/">102. Binary Tree Level
 *      Order Traversal</a>
 */
public class N0102 {
    /**
     * 思想：递归。为每一层添加一个列表。遍历某个结点时，将其加在所在层的列表中。
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root, 0, res);

        return res;
    }

    /**
     * @param root
     * @param level 从0开始
     * @param res
     */
    private void levelOrder(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        if (level == res.size()) {// 进到一个新的层，res还没有该层的列表，则为该层添加一个列表。
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);// 添加到该层列表

        levelOrder(root.left, level + 1, res);
        levelOrder(root.right, level + 1, res);
    }
}
