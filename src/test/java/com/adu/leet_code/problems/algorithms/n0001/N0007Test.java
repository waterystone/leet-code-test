package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/20 18:26
 */
public class N0007Test extends BaseTest {
    private N0007 n0007 = new N0007();

    @Test
    public void reverse() {
        int res = n0007.reverse(-1080);
        logRes(res);
    }
}
