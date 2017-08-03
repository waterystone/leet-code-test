package com.adu.leet_code.problems.algorithms.n0001;

import java.util.List;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/3 14:51
 */
public class N0047Test extends BaseTest {
    private N0047 n0047 = new N0047();

    @Test
    public void permuteUnique() {
        int[] nums = { 0, 0, 0, 1, 9 };
        List<List<Integer>> res = n0047.permuteUnique(nums);
        print(res);
    }
}
