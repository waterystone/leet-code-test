package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.TreeNode;

/**
 * @author yunjie.du
 * @date 2017/8/15 11:12
 */
public class N0099Test extends BaseTest {
    private N0099 n0099 = new N0099();
    private TreeNode root;

    @Test
    public void recoverTree() {
        n0099.recoverTree(root);
        printTree(root);
    }

    @Before
    public void init() {
        root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
    }
}
