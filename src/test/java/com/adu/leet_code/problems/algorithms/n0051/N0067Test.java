package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/8 17:22
 */
public class N0067Test extends BaseTest {
    private N0067 n0067 = new N0067();

    @Test
    public void addBinary() {
        String a = "11", b = "1";
        String res = n0067.addBinary(a, b);
        logRes(res);
    }
}
