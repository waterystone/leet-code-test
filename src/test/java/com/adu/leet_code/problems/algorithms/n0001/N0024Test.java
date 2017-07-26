package com.adu.leet_code.problems.algorithms.n0001;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.ListNode;

/**
 * @author yunjie.du
 * @date 2017/7/26 10:57
 */
public class N0024Test extends BaseTest {
    private N0024 n0024 = new N0024();
    private ListNode head;

    @Test
    public void swapPairs() {
        ListNode res = n0024.swapPairs(head);
        printList(res);
    }

    @Before
    public void init() {
        head = buildList(Arrays.asList(1));
    }
}
