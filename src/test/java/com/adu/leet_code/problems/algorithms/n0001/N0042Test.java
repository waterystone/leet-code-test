package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/2 11:50
 */
public class N0042Test extends BaseTest {
    private N0042 n0042 = new N0042();

    @Test
    public void trap() {
        int[] height = { 5, 4, 1, 2 };
        int res = n0042.trap(height);
        logRes(res);
    }
}
