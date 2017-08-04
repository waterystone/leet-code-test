package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/4 15:33
 */
public class N0055Test extends BaseTest {
    private N0055 n0055 = new N0055();

    @Test
    public void canJump() {
        int[] nums = { 2, 3, 1, 1, 4 };
        boolean res = n0055.canJump(nums);
        logRes(res);
    }
}
