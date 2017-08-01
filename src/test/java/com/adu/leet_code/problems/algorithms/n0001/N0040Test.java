package com.adu.leet_code.problems.algorithms.n0001;

import java.util.List;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/1 16:41
 */
public class N0040Test extends BaseTest {
    private N0040 n0040 = new N0040();

    @Test
    public void combinationSum2() {
        int[] cadidates = { 10, 1, 2, 7, 6, 1, 5 };
        List<List<Integer>> res = n0040.combinationSum2(cadidates, 8);
        print(res);
    }
}
