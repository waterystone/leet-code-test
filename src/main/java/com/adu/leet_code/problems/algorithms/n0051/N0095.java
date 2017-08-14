package com.adu.leet_code.problems.algorithms.n0051;

import java.util.ArrayList;
import java.util.List;

import com.adu.leet_code.problems.model.TreeNode;

/**
 *
 *
 * 
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * 
 * <pre>
 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/14 14:43
 * @see <a href="https://leetcode.com/problems/unique-binary-search-trees-ii/description/">95. Unique Binary Search
 *      Trees II</a>
 */
public class N0095 {
    /**
     * 思想：1-n每个值依次当root，在某个值k当root时，左子树区间[1,k-1]及右子树区间[k+1,n]都有多种形态。将左子树和右子树的形态分别组合起来挂在k的两侧，就形成了以k为root的结点。
     * 
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        return generateTrees(1, n);
    }

    /**
     * 生成指定区间的排序树
     * 
     * @param start
     * @param end
     * @return
     */
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>(start > end ? 1 : end - start + 1);
        if (start > end) {// 如果区间非法，该侧排序树设置为null
            res.add(null);
            return res;
        }

        for (int k = start; k <= end; k++) {// 每个值依次当做root
            List<TreeNode> leftNodeList = generateTrees(start, k - 1);// 生成区间[start,k-1]的左子树
            List<TreeNode> rightNodeList = generateTrees(k + 1, end);// 生成区间[k+1,end]的右子树

            // 左子树与右子树的各种组合
            for (TreeNode leftNode : leftNodeList) {
                for (TreeNode rightNode : rightNodeList) {
                    TreeNode node = new TreeNode(k);
                    node.left = leftNode;
                    node.right = rightNode;
                    res.add(node);
                }
            }

        }

        return res;
    }
}
