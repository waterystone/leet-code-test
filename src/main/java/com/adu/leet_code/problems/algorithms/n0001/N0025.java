package com.adu.leet_code.problems.algorithms.n0001;

import com.adu.leet_code.problems.model.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a
 * multiple of k then left-out nodes in the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * <pre>
 For example,
 Given this linked list: 1->2->3->4->5
 For k = 2, you should return: 2->1->4->3->5
 For k = 3, you should return: 3->2->1->4->5
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/7/26 11:25
 * @see <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/#/description">Reverse Nodes in k-Group</a>
 */
public class N0025 {
    /**
     * 思想：一组一组进行反转。
     * 
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {// 保证k>=2
            return head;
        }

        ListNode newHead = new ListNode(-1), p = newHead;// p指向上一组的尾结点
        newHead.next = head;// 标杆结点把原链表串起来

        while (p != null) {
            p = reverse(p, k);// 反转p开始的下一组结点，不包括p
        }

        return newHead.next;
    }

    /**
     * 反转head开始的下一组k个结点，不包括head。
     * 
     * @param head
     * @param k
     * @return 下一组的尾结点，方便进行下下一次反转。如果反转失败返回null。
     */
    private ListNode reverse(ListNode head, int k) {
        ListNode start = head.next, end = head;
        for (int i = 0; i < k; i++) {
            end = end.next;
            if (end == null) {// 该组结点数量不够，无须反转，直接失败
                return null;
            }
        }

        // 反转这组的K个结点
        ListNode p = head.next, q = p.next, r = q.next;// p->q->r. k>1, so p&q are NOT null.
        while (true) {
            q.next = p;
            if (q == end) {
                break;
            }

            p = q;
            q = r;
            r = r.next;

        }

        // 原链表串接上该组
        head.next = end;
        start.next = r;

        return start;
    }

}
