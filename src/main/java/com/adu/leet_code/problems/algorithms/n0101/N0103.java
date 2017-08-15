package com.adu.leet_code.problems.algorithms.n0101;

import java.util.LinkedList;
import java.util.List;

import com.adu.leet_code.problems.model.TreeNode;

/**
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then
 * right to left for the next level and alternate between).
 * 
 * <pre>
 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]
 * </pre>
 *
 * @author yunjie.du
 * @date 2017/8/15 15:11
 * @see <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/">103. Binary Tree
 *      Zigzag Level Order Traversal</a>
 */
public class N0103 {
    /**
     * 思想：递归。为每一层添加一个列表。遍历某个结点时，将其加在所在层的列表中。在偶数层(从0开始)时，加到尾部；奇数层时，加到头部。
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        zigzagLevelOrder(root, 0, res);

        return res;
    }

    private void zigzagLevelOrder(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        if (level == res.size()) {
            res.add(new LinkedList<>());// 使用链表，加到头部是O(1)
        }
        if (level % 2 == 0) {// 加到尾部
            res.get(level).add(root.val);
        } else {// 加到头部
            ((LinkedList<Integer>) res.get(level)).addFirst(root.val);
        }

        zigzagLevelOrder(root.left, level + 1, res);
        zigzagLevelOrder(root.right, level + 1, res);
    }
}
