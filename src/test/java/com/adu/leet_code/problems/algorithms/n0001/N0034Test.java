package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/28 17:18
 */
public class N0034Test extends BaseTest {
    private N0034 n0034 = new N0034();

    @Test
    public void searchRange() {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 8, 10, 10 };
        int[] res = n0034.searchRange(nums, 4);
        logRes(res);
    }
}
