package com.adu.leet_code.problems.algorithms.n0101;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.TreeNode;

/**
 * @author yunjie.du
 * @date 2017/8/15 15:48
 */
public class N0104Test extends BaseTest {
    private N0104 n0104 = new N0104();
    private TreeNode root;

    @Test
    public void maxDepth() {
        int res = n0104.maxDepth(root);
        logRes(res);
    }

    @Before
    public void init() {
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
    }
}
