package com.adu.leet_code.problems.algorithms.n0051;

import com.adu.leet_code.problems.model.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 <= m <= n <= length of list.
 * 
 * @author yunjie.du
 * @date 2017/8/11 18:38
 * @see <a href="https://leetcode.com/problems/reverse-linked-list-ii/description/">92. Reverse Linked List II</a>
 */
public class N0092 {
    /**
     * 思想：[m,n]间的元素反转后，再与前后串接起来。
     * 
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(-1), tail = newHead, p, q, r;
        tail.next = head;

        for (int i = 1; i < m; i++) {// 找到m的前一个结点
            tail = tail.next;
        }

        p = tail.next;// p指向反转后的头结点
        q = p.next;// q指向当前结点
        r = q;// r指向下一个结点
        for (int i = m + 1; i <= n; i++) {
            r = q.next;// 保存下一结点

            q.next = p;// 当前结点指向反转后的链表头
            p = q;// 链表头p指向当前结点
            q = r;// 当前元素指向下一结点，方便下一次处理
        }

        tail.next.next = r;// 反转链尾与后边的串接
        tail.next = p;// 前边的与反转链头串接

        return newHead.next;
    }
}
