package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/8 11:06
 */
public class N0064Test extends BaseTest {
    private N0064 n0064 = new N0064();

    @Test
    public void minPathSum() {
        int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int res = n0064.minPathSum(grid);
        logRes(res);
    }
}
