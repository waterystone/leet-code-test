package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/21 11:03
 */
public class N0009Test extends BaseTest {
    private N0009 n0009 = new N0009();

    @Test
    public void isPalindrome() {
        boolean res = n0009.isPalindrome(10);
        logRes(res);
    }
}
