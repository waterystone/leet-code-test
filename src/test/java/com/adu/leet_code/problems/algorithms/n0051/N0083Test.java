package com.adu.leet_code.problems.algorithms.n0051;

import java.util.Arrays;

import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.ListNode;

/**
 * @author yunjie.du
 * @date 2017/8/10 18:10
 */
public class N0083Test extends BaseTest {
    private N0083 n0083 = new N0083();

    @Test
    public void deleteDuplicates() {
        ListNode head = buildList(Arrays.asList(1, 1, 2, 3, 3));
        ListNode res = n0083.deleteDuplicates(head);
        printList(res);
    }
}
