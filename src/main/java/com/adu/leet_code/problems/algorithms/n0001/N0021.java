package com.adu.leet_code.problems.algorithms.n0001;

import com.adu.leet_code.problems.model.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes
 * of the first two lists.
 * 
 * @author yunjie.du
 * @date 2017/7/25 11:38
 * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/#/description">Merge Two Sorted Lists</a>
 */
public class N0021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1), t = head, p = l1, q = l2;
        while (p != null && q != null) {
            if (p.val < q.val) {
                t.next = p;
                p = p.next;
            } else {
                t.next = q;
                q = q.next;
            }
            t = t.next;
        }

        t.next = p != null ? p : q;

        return head.next;
    }

}
