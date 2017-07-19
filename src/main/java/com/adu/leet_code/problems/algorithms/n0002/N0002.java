package com.adu.leet_code.problems.algorithms.n0002;

/**
 * @author yunjie.du
 * @date 2017/7/19 15:25
 */
public class N0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(-1), prev = head;
        ListNode p1 = l1, p2 = l2;
        int flag = 0;

        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + flag;
            flag = sum < 10 ? 0 : 1;

            ListNode node = new ListNode(sum % 10);
            prev.next = node;
            prev = node;
            p1 = p1.next;
            p2 = p2.next;
        }

        ListNode p = p1 != null ? p1 : p2;

        while (p != null) {
            int sum = p.val + flag;
            flag = sum < 10 ? 0 : 1;

            ListNode node = new ListNode(sum % 10);
            prev.next = node;
            prev = node;
            p = p.next;
        }

        if (flag > 0) {
            prev.next = new ListNode(1);
        }

        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
