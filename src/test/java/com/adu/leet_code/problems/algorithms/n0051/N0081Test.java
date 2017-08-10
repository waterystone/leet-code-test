package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/10 17:05
 */
public class N0081Test extends BaseTest {
    private N0081 n0081 = new N0081();

    @Test
    public void search() {
        int[] nums = { 1, 1, 3 };
        boolean res = n0081.search(nums, 3);
        logRes(res);
    }
}
