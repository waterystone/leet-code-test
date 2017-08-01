package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/1 11:12
 */
public class N0035Test extends BaseTest {
    private N0035 n0035 = new N0035();

    @Test
    public void searchInsert() {
        int[] nums = { 1, 3, 5, 6 };
        int res = n0035.searchInsert(nums, 2);
        logRes(res);
    }
}
