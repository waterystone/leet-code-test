package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/10 10:38
 */
public class N0075Test extends BaseTest {
    private N0075 n0075 = new N0075();

    @Test
    public void sortColors() {
        int[] nums = { 0 };
        n0075.sortColors(nums);
        logRes(nums);
    }
}
