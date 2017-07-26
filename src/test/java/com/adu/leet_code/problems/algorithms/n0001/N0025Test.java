package com.adu.leet_code.problems.algorithms.n0001;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.ListNode;

/**
 * @author yunjie.du
 * @date 2017/7/26 12:01
 */
public class N0025Test extends BaseTest {
    private N0025 n0025 = new N0025();
    private ListNode head;

    @Test
    public void reverseKGroup() {
        ListNode res = n0025.reverseKGroup(head, 2);
        printList(res);
    }

    @Before
    public void init() {
        head = buildList(Arrays.asList(1, 2));
    }
}
