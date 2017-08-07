package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/4 18:55
 */
public class N0060Test extends BaseTest {
    private N0060 n0060 = new N0060();

    @Test
    public void getPermutation() {
        String res = n0060.getPermutation(3, 4);
        logRes(res);
    }
}
