package com.adu.leet_code.problems.algorithms.n0051;

import java.util.List;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/4 14:42
 */
public class N0054Test extends BaseTest {
    private N0054 n0054 = new N0054();

    @Test
    public void spiralOrder() {
        int[][] matrix = { { 1, 2, 3, 4, 5, 6 } };
        List<Integer> res = n0054.spiralOrder(matrix);
        logRes(res);
    }
}
