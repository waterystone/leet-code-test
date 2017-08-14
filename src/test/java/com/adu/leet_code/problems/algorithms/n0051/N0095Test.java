package com.adu.leet_code.problems.algorithms.n0051;

import java.util.List;

import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.TreeNode;

/**
 * @author yunjie.du
 * @date 2017/8/14 14:54
 */
public class N0095Test extends BaseTest {
    private N0095 n0095 = new N0095();

    @Test
    public void generateTrees() {
        List<TreeNode> res = n0095.generateTrees(3);
        printTree(res);
    }
}
