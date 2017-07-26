package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/26 18:43
 */
public class N0029Test extends BaseTest {
    private N0029 n0029 = new N0029();

    @Test
    public void divide() {
        int res = n0029.divide(-2147483648, -2147483648);
        logRes(res);
    }
}
