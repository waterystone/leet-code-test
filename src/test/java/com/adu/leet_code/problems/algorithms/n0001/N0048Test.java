package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/3 16:23
 */
public class N0048Test extends BaseTest {
    private N0048 n0048 = new N0048();
    int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

    @Test
    public void rotate() {
        n0048.rotate(matrix);
        logRes(matrix);
    }

}
