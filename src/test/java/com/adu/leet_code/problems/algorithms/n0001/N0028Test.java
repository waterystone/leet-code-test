package com.adu.leet_code.problems.algorithms.n0001;

import com.adu.leet_code.BaseTest;
import org.junit.Test;

/**
 * @author yunjie.du
 * @date 2017/7/26 17:43
 */
public class N0028Test extends BaseTest {
    private N0028 n0028=new N0028();

    @Test
    public void strStr() {
        int res = n0028.strStr("abcdef", "cdef");
        logRes(res);
    }
}
