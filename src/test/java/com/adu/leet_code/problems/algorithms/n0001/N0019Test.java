package com.adu.leet_code.problems.algorithms.n0001;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.google.common.collect.Lists;

/**
 * @author yunjie.du
 * @date 2017/7/24 18:19
 */
public class N0019Test extends BaseTest {
    private N0019 n0019 = new N0019();
    private N0019.ListNode head;

    @Test
    public void removeNthFromEnd() {
        n0019.removeNthFromEnd(head, 2);
        printList(head);
    }

    private void printList(N0019.ListNode head) {
        // print
        List<Integer> list = Lists.newArrayList();
        N0019.ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }

        logRes(list);
    }

    @Before
    public void init() {
        head = new N0019.ListNode(1);
        N0019.ListNode p1 = new N0019.ListNode(2);
        head.next = p1;
        N0019.ListNode p2 = new N0019.ListNode(3);
        p1.next = p2;
        N0019.ListNode p3 = new N0019.ListNode(4);
        p2.next = p3;
        N0019.ListNode p4 = new N0019.ListNode(5);
        p3.next = p4;

    }
}
