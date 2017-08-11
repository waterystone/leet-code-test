package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/11 11:56
 */
public class N0087Test extends BaseTest {
    private N0087 n0087 = new N0087();

    @Test
    public void isScramble() {
        boolean res = n0087.isScramble("great", "rgaet");
        logRes(res);
    }
}
