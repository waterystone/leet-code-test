package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/4 17:45
 */
public class N0058Test extends BaseTest {
    private N0058 n0058 = new N0058();

    @Test
    public void lengthOfLastWord() {
        int res = n0058.lengthOfLastWord("asfd ");
        logRes(res);
    }
}
