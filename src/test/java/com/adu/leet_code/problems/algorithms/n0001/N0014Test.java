package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/21 17:49
 */
public class N0014Test extends BaseTest {
    private N0014 n0014 = new N0014();

    @Test
    public void longestCommonPrefix() {
        String[] strs = { "babb", "caa" };
        String res = n0014.longestCommonPrefix(strs);
        logRes(res);
    }
}
