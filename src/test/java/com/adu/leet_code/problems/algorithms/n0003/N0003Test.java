package com.adu.leet_code.problems.algorithms.n0003;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/19 16:56
 */
public class N0003Test extends BaseTest {
    private N0003 n0003 = new N0003();

    @Test
    public void lengthOfLongestSubstring() {
        int res = n0003.lengthOfLongestSubstring("abba");
        logRes(res);
    }
}
