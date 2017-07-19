package com.adu.leet_code.problems.algorithms.n0002;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.google.common.collect.Lists;

/**
 * @author yunjie.du
 * @date 2017/7/19 15:45
 */
public class N0002Test extends BaseTest {
    private N0002 n0002 = new N0002();
    private N0002.ListNode l1, l2;

    @Test
    public void addTwoNumbers() {
        N0002.ListNode res = n0002.addTwoNumbers(l1, l2);

        // print
        List<Integer> list = Lists.newArrayList();
        N0002.ListNode p = res;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }

        logRes(list);
    }

    @Before
    public void init() {
        l1 = new N0002.ListNode(2);
        N0002.ListNode p12 = new N0002.ListNode(4);
        l1.next = p12;
        N0002.ListNode p13 = new N0002.ListNode(3);
        p12.next = p13;
        N0002.ListNode p14 = new N0002.ListNode(9);
        p13.next = p14;

        l2 = new N0002.ListNode(5);
        N0002.ListNode p22 = new N0002.ListNode(6);
        l2.next = p22;
        N0002.ListNode p23 = new N0002.ListNode(4);
        p22.next = p23;

    }
}
