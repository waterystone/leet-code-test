package com.adu.leet_code.problems.algorithms.n0051;

import com.adu.leet_code.problems.model.ListNode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * <pre>
 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/7 11:37
 * @see <a href="https://leetcode.com/problems/rotate-list/description/">61. Rotate List</a>
 */
public class N0061 {
    /**
     * 快慢指针，快的比慢的领先k个。这样快的到尾部时，慢的正好在新链表的尾部。
     * 
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode fast = head, slow = head, newHead;
        int size = 0;// 链表长度

        for (int i = 0; i < k && fast != null; i++) {// 快指针先移k次
            fast = fast.next;
            size++;
        }
        if (fast == null) {// 如果k大于链表长度
            k = k % size;// 取余
            if (k == 0) {
                return head;
            }
            fast = head;// 从头再来
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }
        }

        while (fast.next != null) {// 快慢同时前移，直到快的到达尾部结点
            slow = slow.next;
            fast = fast.next;
        }

        newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }

}
