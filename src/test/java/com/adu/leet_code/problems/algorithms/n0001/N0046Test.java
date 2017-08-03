package com.adu.leet_code.problems.algorithms.n0001;

import java.util.List;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/3 12:27
 */
public class N0046Test extends BaseTest {
    private N0046 n0046 = new N0046();

    @Test
    public void permute() {
        int[] nums = { 1, 2, 3, 4 };
        List<List<Integer>> res = n0046.permute(nums);
        logRes(res);
    }
}
