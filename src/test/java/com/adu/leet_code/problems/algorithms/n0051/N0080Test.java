package com.adu.leet_code.problems.algorithms.n0051;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/10 16:21
 */
public class N0080Test extends BaseTest {
    private N0080 n0080 = new N0080();

    @Test
    public void removeDuplicates() {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int res = n0080.removeDuplicates(nums);
        logRes(nums);
        logRes(res);
    }
}
