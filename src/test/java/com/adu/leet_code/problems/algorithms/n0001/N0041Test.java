package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/1 18:54
 */
public class N0041Test extends BaseTest {
    private N0041 n0041 = new N0041();

    @Test
    public void firstMissingPositive() {
        int[] nums = { 1 };
        int res = n0041.firstMissingPositive(nums);
        logRes(res);
    }
}
