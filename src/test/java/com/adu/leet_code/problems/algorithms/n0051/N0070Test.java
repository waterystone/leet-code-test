package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/9 11:37
 */
public class N0070Test extends BaseTest {
    private N0070 n0070 = new N0070();

    @Test
    public void climbStairs() {
        int res = n0070.climbStairs(2);
        logRes(res);
    }
}
