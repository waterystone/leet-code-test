package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/24 11:35
 */
public class N0016Test extends BaseTest {
    private N0016 n0016 = new N0016();

    @Test
    public void threeSumClosest() {
        int[] nums = { 0, 0, 0 };
        int res = n0016.threeSumClosest(nums, 1);
        logRes(res);
    }
}
