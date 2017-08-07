package com.adu.leet_code.problems.algorithms.n0051;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.adu.leet_code.BaseTest;
import com.adu.leet_code.problems.model.ListNode;

/**
 * @author yunjie.du
 * @date 2017/8/7 11:47
 */
public class N0061Test extends BaseTest {
    private N0061 n0061 = new N0061();
    private ListNode head;

    @Test
    public void rotateRight() {
        ListNode res = n0061.rotateRight(head, 3);
        printList(res);
    }

    @Before
    public void init() {
        head = buildList(Arrays.asList(1, 2));
    }
}
