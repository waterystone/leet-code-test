package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/9 14:24
 */
public class N0071Test extends BaseTest {
    private N0071 n0071 = new N0071();

    @Test
    public void simplifyPath() {
        String res = n0071.simplifyPath("///");
        logRes(res);
    }
}
