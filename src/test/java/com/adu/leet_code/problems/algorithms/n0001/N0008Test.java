package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/20 19:02
 */
public class N0008Test extends BaseTest {
    public N0008 n0008 = new N0008();

    @Test
    public void myAtoi() {
        int res = n0008.myAtoi("2147483648");
        logRes(res);
    }
}
