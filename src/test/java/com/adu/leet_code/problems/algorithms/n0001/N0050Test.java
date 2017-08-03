package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/3 18:02
 */
public class N0050Test extends BaseTest {
    private N0050 n0050 = new N0050();

    @Test
    public void myPow() {
        double res = n0050.myPow(2.0,5);
        logRes(res);
    }
}
