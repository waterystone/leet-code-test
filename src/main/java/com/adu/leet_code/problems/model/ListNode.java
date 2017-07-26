package com.adu.leet_code.problems.model;

/**
 * @author yunjie.du
 * @date 2017/7/25 14:27
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "val=" + val;
    }
}
