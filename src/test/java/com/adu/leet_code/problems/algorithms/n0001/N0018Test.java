package com.adu.leet_code.problems.algorithms.n0001;

import java.util.List;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/24 16:02
 */
public class N0018Test extends BaseTest {
    private N0018 n0018 = new N0018();

    @Test
    public void fourSum() {
        int[] nums = { 0, 0, 0, 0 };
        List<List<Integer>> res = n0018.fourSum(nums, 0);
        logRes(res);
    }
}
