package com.adu.leet_code.problems.algorithms.n0051;

import java.util.Arrays;

import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.ListNode;

/**
 * @author yunjie.du
 * @date 2017/8/11 18:52
 */
public class N0092Test extends BaseTest {
    private N0092 n0092 = new N0092();

    @Test
    public void reverseBetween() {
        ListNode head = buildList(Arrays.asList(3, 5));
        ListNode res = n0092.reverseBetween(head, 1, 1);
        printList(res);
    }
}
