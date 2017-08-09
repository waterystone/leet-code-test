package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/9 16:38
 */
public class N0073Test extends BaseTest {
    private N0073 n0073 = new N0073();

    @Test
    public void setZeroes() {
        int[][] matrix = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };
        n0073.setZeroes(matrix);
        logRes(matrix);
    }
}
