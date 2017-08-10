package com.adu.leet_code.problems.algorithms.n0051;

import java.util.List;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/10 11:25
 */
public class N0077Test extends BaseTest {
    private N0077 n0077 = new N0077();

    @Test
    public void combine() {
        List<List<Integer>> res = n0077.combine(4, 2);
        print(res);
    }
}
