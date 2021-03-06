package com.adu.leet_code.problems.algorithms.n0001;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.ListNode;

/**
 * @author yunjie.du
 * @date 2017/7/19 15:45
 */
public class N0002Test extends BaseTest {
    private N0002 n0002 = new N0002();
    private ListNode l1, l2;

    @Test
    public void addTwoNumbers() {
        ListNode res = n0002.addTwoNumbers(l1, l2);
        printList(res);
    }

    @Before
    public void init() {
        l1 = buildList(Arrays.asList(2, 4, 3, 9));
        l2 = buildList(Arrays.asList(5, 6, 4));
    }
}
