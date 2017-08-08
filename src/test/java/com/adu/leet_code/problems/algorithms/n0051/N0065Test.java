package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/8 11:33
 */
public class N0065Test extends BaseTest {
    private N0065 n0065 = new N0065();

    @Test
    public void isNumber() {
        boolean res = n0065.isNumber("0000");
        logRes(res);
    }
}
