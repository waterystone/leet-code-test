package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/10 18:20
 */
public class N0084Test extends BaseTest {
    private N0084 n0084 = new N0084();

    @Test
    public void largestRectangleArea() {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        int res = n0084.largestRectangleArea(heights);
        logRes(res);
    }
}
