package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/2 16:49
 */
public class N0043Test extends BaseTest {
    private N0043 n0043 = new N0043();

    @Test
    public void multiply() {
        String num1 = "15", num2 = "16";
        String res = n0043.multiply(num1, num2);
        logRes(res);
    }
}
