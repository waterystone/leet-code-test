package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/14 15:45
 */
public class N0096Test extends BaseTest {
    private N0096 n0096 = new N0096();

    @Test
    public void numTrees() {
        int res = n0096.numTrees(3);
        logRes(res);
    }
}
