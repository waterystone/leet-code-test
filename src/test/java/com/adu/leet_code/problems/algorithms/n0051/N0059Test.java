package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/4 18:01
 */
public class N0059Test extends BaseTest {
    private N0059 n0059 = new N0059();

    @Test
    public void generateMatrix() {
        int[][] res = n0059.generateMatrix(3);
        logRes(res);
    }
}
