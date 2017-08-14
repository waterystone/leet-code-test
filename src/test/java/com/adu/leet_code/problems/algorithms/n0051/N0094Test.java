package com.adu.leet_code.problems.algorithms.n0051;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.TreeNode;

/**
 * @author yunjie.du
 * @date 2017/8/14 14:31
 */
public class N0094Test extends BaseTest {
    private N0094 n0094 = new N0094();
    private TreeNode root;

    @Test
    public void inorderTraversal() {
        List<Integer> res = n0094.inorderTraversal(root);
        logRes(res);
    }

    @Before
    public void init() {
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
    }
}
