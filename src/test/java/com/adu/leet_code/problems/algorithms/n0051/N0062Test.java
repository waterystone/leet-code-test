package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/7 15:36
 */
public class N0062Test extends BaseTest {
    private N0062 n0062 = new N0062();

    @Test
    public void uniquePaths() {
        int res = n0062.uniquePaths(36, 7);
        logRes(res);
    }
}
