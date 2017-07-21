package com.adu.leet_code.problems.algorithms.n0001;

import java.util.List;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/21 18:15
 */
public class N0015Test extends BaseTest {
    private N0015 n0015 = new N0015();

    @Test
    public void threeSum() {
        int[] nums = { 0, 0, 0, 0, 0, 0 };
        List<List<Integer>> res = n0015.threeSum(nums);
        print(res);
    }
}
