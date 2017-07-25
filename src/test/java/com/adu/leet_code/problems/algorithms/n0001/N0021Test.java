package com.adu.leet_code.problems.algorithms.n0001;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.ListNode;

/**
 * @author yunjie.du
 * @date 2017/7/25 11:48
 */
public class N0021Test extends BaseTest {
    private N0021 n0021 = new N0021();
    private ListNode l1, l2;

    @Test
    public void mergeTwoLists() {
        ListNode res = n0021.mergeTwoLists(l1, l2);
        printList(res);
    }

    @Before
    public void init() {
        l1 = buildList(Arrays.asList(1, 3, 5, 6));
        l2 = buildList(Arrays.asList(2, 4, 6));
    }
}
