package com.adu.leet_code.problems.algorithms.n0001;

import com.adu.leet_code.BaseTest;
import org.junit.Test;

/**
 * @author yunjie.du
 * @date 2017/8/1 15:23
 */
public class N0038Test extends BaseTest {
    private N0038 n0038=new N0038();
    @Test
    public void countAndSay() {
        String res = n0038.countAndSay(4);
        logRes(res);
    }
}
