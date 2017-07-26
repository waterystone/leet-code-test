package com.adu.leet_code.problems.algorithms.n0001;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.ListNode;

/**
 * @author yunjie.du
 * @date 2017/7/25 17:29
 */
public class N0023Test extends BaseTest {
    private N0023 n0023 = new N0023();
    ListNode[] lists;

    @Test
    public void mergeKLists() {
        ListNode res = n0023.mergeKLists(lists);
        printList(res);
    }

    @Before
    public void init() {
        lists = new ListNode[4];
        lists[0] = buildList(Arrays.asList(1, 3, 5, 9));
        lists[1] = buildList(Arrays.asList(5));
        lists[2] = buildList(Arrays.asList(2, 4, 7));
        lists[3] = buildList(Arrays.asList(0, 10));
    }
}
