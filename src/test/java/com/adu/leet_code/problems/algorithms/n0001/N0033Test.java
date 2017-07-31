package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/28 15:52
 */
public class N0033Test extends BaseTest {
    private N0033 n0033 = new N0033();

    @Test
    public void search() {
        int[] nums = { 1 };
        int res = n0033.search(nums, 0);
        logRes(res);
    }
}
