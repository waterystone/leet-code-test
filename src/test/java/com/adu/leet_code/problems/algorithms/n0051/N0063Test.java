package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/7 16:41
 */
public class N0063Test extends BaseTest {
    private N0063 n0063 = new N0063();

    @Test
    public void uniquePathsWithObstacles() {
        int[][] obstacleGrid = { { 0, 0 }, { 1, 1 }, { 0, 0 } };
        int res = n0063.uniquePathsWithObstacles(obstacleGrid);
        logRes(res);
    }

}
