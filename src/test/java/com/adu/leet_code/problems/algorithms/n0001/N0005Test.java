package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/20 11:28
 */
public class N0005Test extends BaseTest {
    private N0005 n0005 = new N0005();

    @Test
    public void longestPalindrome() {
        String res = n0005.longestPalindrome(
                "abcbe");

        logRes(res);
    }
}
