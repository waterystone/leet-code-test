package com.adu.leet_code.leet_code.problems.algorithms;

import org.junit.Test;

import com.adu.leet_code.leet_code.BaseTest;
import com.adu.leet_code.problems.algorithms.N0001;

/**
 * @author yunjie.du
 * @date 2017/4/24 16:16
 */
public class N0001Test extends BaseTest {
    private N0001 n0001 = new N0001();

    @Test
    public void twoSum() {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        int[] res = n0001.twoSum(nums, target);
        logRes(res);
    }
}
