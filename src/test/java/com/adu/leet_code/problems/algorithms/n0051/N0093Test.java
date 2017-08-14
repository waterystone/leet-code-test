package com.adu.leet_code.problems.algorithms.n0051;

import java.util.List;

import org.junit.Test;

import com.adu.leet_code.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/14 11:07
 */
public class N0093Test extends BaseTest {
    private N0093 n0093 = new N0093();

    @Test
    public void restoreIpAddresses() {
        List<String> res = n0093.restoreIpAddresses("010010");
        print(res);
    }
}
