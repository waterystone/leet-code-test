package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/21 14:39
 */
public class N0011Test extends BaseTest {
    private N0011 n0011 = new N0011();

    @Test
    public void maxArea() {
        int[] height = new int[] { 1, 1 };
        int res = n0011.maxArea(height);
        logRes(res);
    }

}
