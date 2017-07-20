package com.adu.leet_code.problems.algorithms.n0001;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * <pre>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/7/19 15:25
 * @see <a href="https://leetcode.com/problems/two-sum/#/description">Two Sum</a>
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
