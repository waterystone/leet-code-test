package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/10 15:02
 */
public class N0079Test extends BaseTest {
    private N0079 n0079 = new N0079();

    @Test
    public void exist() {
        char[][] board = { { 'A', 'A' } };
        boolean res = n0079.exist(board, "AAA");
        logRes(res);
    }

}
