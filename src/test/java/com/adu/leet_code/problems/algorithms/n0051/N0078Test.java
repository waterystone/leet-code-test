package com.adu.leet_code.problems.algorithms.n0051;

import java.util.List;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/10 14:40
 */
public class N0078Test extends BaseTest {
    private N0078 n0078 = new N0078();

    @Test
    public void subsets() {
        int[] nums = { 1, 2, 3, 4 };
        List<List<Integer>> res = n0078.subsets(nums);
        print(res);
    }
}
