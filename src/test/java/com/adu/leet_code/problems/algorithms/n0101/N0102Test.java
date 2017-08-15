package com.adu.leet_code.problems.algorithms.n0101;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.TreeNode;

/**
 * @author yunjie.du
 * @date 2017/8/15 11:53
 */
public class N0102Test extends BaseTest {
    private N0102 n0102 = new N0102();
    private TreeNode root;

    @Test
    public void levelOrder() {
        List<List<Integer>> res = n0102.levelOrder(root);
        print(res);
    }

    @Before
    public void init() {
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
    }

}
