package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/11 17:57
 */
public class N0091Test extends BaseTest {
    private N0091 n0091 = new N0091();

    @Test
    public void numDecodings() {
        int res = n0091.numDecodings("17");
        logRes(res);
    }
}
