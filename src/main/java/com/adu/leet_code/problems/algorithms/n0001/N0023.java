package com.adu.leet_code.problems.algorithms.n0001;

import java.util.HashSet;
import java.util.Set;

import com.adu.leet_code.problems.model.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * @author yunjie.du
 * @date 2017/7/25 17:22
 * @see <a href="https://leetcode.com/problems/merge-k-sorted-lists/#/description">Merge k Sorted Lists</a>
 */
public class N0023 {
    /**
     * 思想：借用归并排序。
     * 
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeKLists(lists, 0, lists.length - 1);
    }

    /**
     * 对指定范围内的归并排序
     * 
     * @param lists
     * @param i 开始下标，包括。
     * @param j 结束下标，包括。
     * @return
     */
    private ListNode mergeKLists(ListNode[] lists, int i, int j) {
        if (i == j) {
            return lists[i];
        }

        int mid = (j + i) / 2;// 中间位置
        ListNode left = mergeKLists(lists, i, mid);
        ListNode right = mergeKLists(lists, mid + 1, j);
        return merge2Lists(left, right);// 归并
    }

    private ListNode merge2Lists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1), t = head, p = list1, q = list2;
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

    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode head = new ListNode(-1), p = head;
        Set<Integer> set = new HashSet<>(lists.length);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                set.add(i);
            }
        }

        while (true) {
            int i = findMin(lists, set);
            if (i == -1) {
                break;
            }
            p.next = lists[i];
            p = p.next;

            if (lists[i].next != null) {
                lists[i] = lists[i].next;
            } else {
                set.remove(i);
            }
        }

        return head.next;
    }

    private int findMin(ListNode[] lists, Set<Integer> set) {
        int res = -1, min = Integer.MAX_VALUE;
        for (int i : set) {
            if (lists[i].val < min) {
                res = i;
                min = lists[i].val;
            }
        }

        return res;
    }
}
