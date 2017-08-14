package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/14 16:30
 */
public class N0097Test extends BaseTest {
    private N0097 n0097 = new N0097();

    @Test
    public void isInterleave() {
        boolean res = n0097.isInterleave("ab", "bc", "bbac");
        logRes(res);
    }
}
