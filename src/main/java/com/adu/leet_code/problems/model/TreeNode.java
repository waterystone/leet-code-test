package com.adu.leet_code.problems.model;

/**
 * @author yunjie.du
 * @date 2017/8/14 14:20
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "val=" + val;
    }
}
