package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/4 11:38
 */
public class N0053Test extends BaseTest {
    private N0053 n0053 = new N0053();

    @Test
    public void maxSubArray() {
        int[] nums = { -1 };
        int res = n0053.maxSubArray(nums);
        logRes(res);
    }
}
