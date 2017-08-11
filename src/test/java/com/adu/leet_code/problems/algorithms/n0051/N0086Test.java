package com.adu.leet_code.problems.algorithms.n0051;

import java.util.Arrays;

import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.ListNode;

/**
 * @author yunjie.du
 * @date 2017/8/11 11:11
 */
public class N0086Test extends BaseTest {
    private N0086 n0086 = new N0086();

    @Test
    public void partition() {
        ListNode head = buildList(Arrays.asList(1, 4, 3, 2, 5, 2));
        ListNode res = n0086.partition(head, 3);
        printList(res);
    }
}
