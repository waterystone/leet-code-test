package com.adu.leet_code.problems.algorithms.n0051;

import java.util.List;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/8 17:59
 */
public class N0068Test extends BaseTest {
    private N0068 n0068 = new N0068();

    @Test
    public void fullJustify() {
        String[] words = { "a" };
        List<String> res = n0068.fullJustify(words, 1);
        print(res);
    }
}
