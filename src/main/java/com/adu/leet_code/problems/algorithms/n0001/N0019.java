package com.adu.leet_code.problems.algorithms.n0001;

import com.adu.leet_code.problems.model.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 * 
 * <pre>
 Given linked list: 1->2->3->4->5, and n = 2.
 After removing the second node from the end, the linked list becomes 1->2->3->5.
 * </pre>
 * 
 * Note: Given n will always be valid. Try to do this in one pass.
 * 
 * @author yunjie.du
 * @date 2017/7/24 18:11
 * @see <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/#/description">Remove Nth Node From End
 *      of List</a>
 */
public class N0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(-1);// 标杆结点
        start.next = head;

        ListNode fast = start, slow = start;
        for (int i = 0; i <= n; i++) {// fast向前移n+1次
            fast = fast.next;
        }

        while (fast != null) {// fast与slow同速向后移，直到slow指向目标结点的前一个结点
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;// 跨过目标结点

        return start.next;
    }

    /**
     * 思想：先求出链表总长度s,删除倒数第n个元素等价于删除正数第s-n+1个元素。
     * 
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        int length = getLength(head);// 求出长度
        if (length == n) {// 如果目标是头结点
            return head.next;
        }

        int m = length - n + 1;// 正数计数
        ListNode p = head;
        for (int i = 0; i < m - 2; i++) {// p指向目标结点的前一个结点
            p = p.next;
        }
        p.next = p.next.next;// 跨过目标结点

        return head;

    }

    /**
     * 求链表长度
     * 
     * @param head
     * @return
     */
    private int getLength(ListNode head) {
        int res = 0;
        ListNode p = head;
        while (p != null) {
            res++;
            p = p.next;
        }

        return res;
    }

}
