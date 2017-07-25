package com.adu.leet_code.problems.algorithms.n0001;

import java.util.List;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/25 15:45
 */
public class N0022Test extends BaseTest {
    private N0022 n0022 = new N0022();

    @Test
    public void generateParenthesis() {
        List<String> res = n0022.generateParenthesis(3);
        logRes(res);
    }
}
