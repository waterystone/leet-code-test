package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.TreeNode;

/**
 * @author yunjie.du
 * @date 2017/8/14 17:54
 */
public class N0098Test extends BaseTest {
    private N0098 n0098 = new N0098();
    private TreeNode root;

    @Test
    public void isValidBST() {
        boolean res = n0098.isValidBST(root);
        logRes(res);
    }

    @Before
    public void init() {
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
    }
}
