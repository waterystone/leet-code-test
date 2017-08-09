package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/9 18:07
 */
public class N0074Test extends BaseTest {
    private N0074 n0074 = new N0074();

    @Test
    public void searchMatrix() {
        int[][] matrix = { { 1 } };
        boolean res = n0074.searchMatrix(matrix, 2);
        logRes(res);
    }
}
