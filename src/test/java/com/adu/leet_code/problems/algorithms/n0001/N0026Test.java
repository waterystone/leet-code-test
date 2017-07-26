package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/26 15:52
 */
public class N0026Test extends BaseTest {
    private N0026 n0026 = new N0026();

    @Test
    public void removeDuplicates() {
        int[] nums = { 1, 1, 2 };
        int res = n0026.removeDuplicates(nums);
        logRes(res);
        logRes(nums);
    }
}
