package com.adu.leet_code.problems.algorithms.n0051;

import java.util.Arrays;

import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.ListNode;

/**
 * @author yunjie.du
 * @date 2017/8/10 17:55
 */
public class N0082Test extends BaseTest {
    private N0082 n0082 = new N0082();

    @Test
    public void deleteDuplicates() {
        ListNode head = buildList(Arrays.asList(1, 2));
        ListNode res = n0082.deleteDuplicates(head);
        printList(res);
    }
}
