package com.adu.leet_code.problems.algorithms.n0051;

import com.adu.leet_code.problems.model.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or
 * equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * <pre>
 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 * </pre>
 * 
 * @author yunjie.du
 * @date 2017/8/11 11:08
 * @see <a href="https://leetcode.com/problems/partition-list/description/">86. Partition List</a>
 */
public class N0086 {
    /**
     * 思想：遍历把链表分成两个子链表：小于x的和大于等于x的，最后再把两个子链表连接起来。
     * 
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(-1), tail1 = head1, head2 = new ListNode(-1), tail2 = head2, p = head;

        while (p != null) {
            if (p.val < x) {// 小于x的串接到链表1
                tail1.next = p;
                tail1 = p;
            } else {// 其他的串接到链表2
                tail2.next = p;
                tail2 = p;
            }

            p = p.next;
        }

        tail1.next = head2.next;// 两个子链表的串接
        tail2.next = null;

        return head1.next;
    }
}
