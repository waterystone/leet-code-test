package com.adu.leet_code.problems.algorithms.n0001;

import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.ListNode;

/**
 * @author yunjie.du
 * @date 2017/7/24 19:02
 */
public class N0020Test extends BaseTest {
    private N0020 n0020 = new N0020();
    private ListNode l1, l2;

    @Test
    public void isValid() {
        boolean res = n0020.isValid("{}([])");
        logRes(res);
    }
}
