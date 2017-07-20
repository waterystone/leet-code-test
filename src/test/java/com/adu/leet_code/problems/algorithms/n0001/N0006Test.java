package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/20 15:40
 */
public class N0006Test extends BaseTest {
    private N0006 n0006 = new N0006();

    @Test
    public void convert() {
        String res = n0006.convert("A", 1);
        logRes(res);
    }

}
