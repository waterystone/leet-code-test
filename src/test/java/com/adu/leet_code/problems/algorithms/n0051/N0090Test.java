package com.adu.leet_code.problems.algorithms.n0051;

import java.util.List;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/11 17:04
 */
public class N0090Test extends BaseTest {
    private N0090 n0090 = new N0090();

    @Test
    public void subsetsWithDup() {
        int[] nums = { 1, 2, 2 };
        List<List<Integer>> res = n0090.subsetsWithDup(nums);
        print(res);
    }
}
