package com.adu.leet_code.problems.algorithms.n0051;

import com.adu.leet_code.problems.model.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the
 * original list.
 * 
 * <pre>
 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/10 17:46
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/">82. Remove Duplicates
 *      from Sorted List II</a>
 */
public class N0082 {
    /**
     * 思想：生成一个新链表，串接出现一次的元素。
     * 
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1), newTail = newHead, p = head, q;
        while (p != null) {// p每次指向一个不同值的元素
            q = p.next;// q为下一个不同于当前值的元素
            while (q != null && q.val == p.val) {
                q = q.next;
            }

            if (p.next == q) {// 如果p与q还相邻，那说明当前元素p只出现一次，加入到新链表中
                newTail.next = new ListNode(p.val);// 追加到新链表尾部
                newTail = newTail.next;
            }

            p = q;// p指向下一个不同元素
        }

        return newHead.next;
    }
}
