package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/27 16:28
 */
public class N0032Test extends BaseTest {
    private N0032 n0032 = new N0032();

    @Test
    public void longestValidParentheses() {
        int res = n0032.longestValidParentheses("((()()(()((()");
        logRes(res);
    }
}
