package com.adu.leet_code.problems.algorithms.n0001;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.ListNode;

/**
 * @author yunjie.du
 * @date 2017/7/24 18:19
 */
public class N0019Test extends BaseTest {
    private N0019 n0019 = new N0019();
    private ListNode head;

    @Test
    public void removeNthFromEnd() {
        n0019.removeNthFromEnd(head, 2);
        printList(head);
    }

    @Before
    public void init() {
        head = buildList(Arrays.asList(1, 2, 3, 4, 5));
    }
}
