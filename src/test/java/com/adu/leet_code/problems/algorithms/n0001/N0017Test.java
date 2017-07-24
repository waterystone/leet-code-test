package com.adu.leet_code.problems.algorithms.n0001;

import java.util.List;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/24 15:06
 */
public class N0017Test extends BaseTest {
    private N0017 n0017 = new N0017();

    @Test
    public void letterCombinations() {
        List<String> res = n0017.letterCombinations("23");
        logRes(res);
    }
}
