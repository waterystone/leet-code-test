package com.adu.leet_code.problems.algorithms.n0051;

import java.util.List;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/11 15:50
 */
public class N0089Test extends BaseTest {
    private N0089 n0089 = new N0089();

    @Test
    public void grayCode() {
        List<Integer> res = n0089.grayCode(3);
        logRes(res);
    }
}
