package com.adu.leet_code.problems.algorithms.n0001;

import com.adu.leet_code.problems.model.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * <pre>
 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.
 * </pre>
 * 
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be
 * changed.
 * 
 * @author yunjie.du
 * @date 2017/7/26 10:43
 * @see <a href="https://leetcode.com/problems/swap-nodes-in-pairs/#/description">Swap Nodes in Pairs</a>
 */
public class N0024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1), t = newHead, p = head, q = p.next;
        while (q != null) {
            t.next = q;
            p.next = q.next;
            q.next = p;

            t = p;
            p = p.next;
            q = p != null ? p.next : null;
        }

        return newHead.next;
    }
}
