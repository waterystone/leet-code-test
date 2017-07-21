package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/21 15:38
 */
public class N0012Test extends BaseTest {
    private N0012 n0012 = new N0012();

    @Test
    public void intToRoman() {
        String res = n0012.intToRoman(99);
        logRes(res);
    }
}
