package com.adu.leet_code.problems.algorithms.n0101;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.TreeNode;

/**
 * @author yunjie.du
 * @date 2017/8/15 15:15
 */
public class N0103Test extends BaseTest {
    private N0103 n0103 = new N0103();
    private TreeNode root;

    @Test
    public void zigzagLevelOrder() {
        List<List<Integer>> res = n0103.zigzagLevelOrder(root);
        print(res);
    }

    @Before
    public void init() {
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
    }

}
