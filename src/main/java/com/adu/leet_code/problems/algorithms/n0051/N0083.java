package com.adu.leet_code.problems.algorithms.n0051;

import com.adu.leet_code.problems.model.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * <pre>
 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/10 18:06
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/">83. Remove Duplicates
 *      from Sorted List</a>
 */
public class N0083 {
    /**
     * 思想：生成一个新链表，对重复的元素只复制一份。
     * 
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1), newTail = newHead, p = head, q;
        while (p != null) {// p每次指向不同值的元素
            newTail.next = new ListNode(p.val);
            newTail = newTail.next;

            q = p.next;// 跳过与当前值相同的元素
            while (q != null && q.val == p.val) {
                q = q.next;
            }
            p = q;// p指向下一个不同值的元素
        }

        return newHead.next;
    }
}
