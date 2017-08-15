package com.adu.leet_code.problems.algorithms.n0101;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.TreeNode;

/**
 * @author yunjie.du
 * @date 2017/8/15 11:32
 */
public class N0101Test extends BaseTest {
    private N0101 n0101 = new N0101();
    private TreeNode root;

    @Test
    public void test() {
        boolean res = n0101.isSymmetric(root);
        logRes(res);
    }

    @Before
    public void init() {
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
    }
}
