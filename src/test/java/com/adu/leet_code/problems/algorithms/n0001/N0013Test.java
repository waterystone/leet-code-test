package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/21 17:18
 */
public class N0013Test extends BaseTest {
    private N0013 n0013 = new N0013();

    @Test
    public void romanToInt() {
        int res = n0013.romanToInt("DCXXI");
        logRes(res);
    }
}
