package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/26 16:33
 */
public class N0027Test extends BaseTest {
    private N0027 n0027 = new N0027();

    @Test
    public void removeElement() {
        int[] nums = { 3, 2, 2, 3 };
        int res = n0027.removeElement(nums, 3);
        logRes(res);
        logRes(nums);
    }
}
