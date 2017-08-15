package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.TreeNode;

/**
 * @author yunjie.du
 * @date 2017/8/15 11:22
 */
public class N0100Test extends BaseTest {
    private N0100 n0100 = new N0100();
    private TreeNode p, q;

    @Test
    public void isSameTree() {
        boolean res = n0100.isSameTree(p, q);
        logRes(res);
    }

    @Before
    public void init() {
        p = new TreeNode(2);
        p.left = new TreeNode(3);
        p.right = new TreeNode(1);

        q = new TreeNode(2);
        q.left = new TreeNode(3);
        q.right = new TreeNode(11);
    }
}
