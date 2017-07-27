package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/27 15:11
 */
public class N0031Test extends BaseTest {
    private N0031 n0031 = new N0031();

    @Test
    public void nextPermutation() {
        int[] nums = { 1, 5, 1 };
        n0031.nextPermutation(nums);
        logRes(nums);
    }
}
