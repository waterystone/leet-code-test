package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/2 18:29
 */
public class N0045Test extends BaseTest {
    private N0045 n0045 = new N0045();

    @Test
    public void jump() {
        int[] nums = { 0 };
        int res = n0045.jump(nums);
        logRes(res);
    }
}
