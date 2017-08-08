package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/8 15:47
 */
public class N0066Test extends BaseTest {
    private N0066 n0066 = new N0066();

    @Test
    public void plusOne() {
        int[] digits = { 9, 9, 9 };
        int[] res = n0066.plusOne(digits);
        logRes(res);
    }
}
