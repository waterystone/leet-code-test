package com.adu.leet_code.problems.algorithms.n0001;

import java.util.List;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/1 15:59
 */
public class N0039Test extends BaseTest {
    private N0039 n0039 = new N0039();

    @Test
    public void combinationSum() {
        int[] candidates = { 1 };
        List<List<Integer>> res = n0039.combinationSum(candidates, 2);
        print(res);
    }
}
