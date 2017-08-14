package com.adu.leet_code;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.leet_code.problems.model.ListNode;
import com.adu.leet_code.problems.model.TreeNode;
import com.google.common.collect.Lists;

/**
 * @author yunjie.du
 * @date 2016/10/19 18:33
 */
public class BaseTest {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected void print(Iterable<?> iterable) {
        Iterator<?> iterator = iterable.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            logger.debug("[{}]{}", ++i, iterator.next());
        }
    }

    protected void print(Map<?, ?> map) {
        int i = 0;
        for (Map.Entry entry : map.entrySet()) {
            logger.debug("[{}]key={},value={}", ++i, entry.getKey(), entry.getValue());
        }
    }

    protected void printTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        logRes(res);
    }

    protected void printTree(List<TreeNode> list) {
        int i = 0;
        for (TreeNode root : list) {
            List<Integer> res = new ArrayList<>();
            traverse(root, res);
            logger.debug("[{}]{}", ++i, res);
        }
    }

    protected void traverse(TreeNode root, List<Integer> res) {
        if (root == null) {
            res.add(null);
            return;
        }

        res.add(root.val);
        traverse(root.left, res);
        traverse(root.right, res);

    }

    protected void printList(ListNode head) {
        List<Integer> list = Lists.newArrayList();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }

        logRes(list);
    }

    protected ListNode buildList(List<Integer> list) {
        ListNode head = new ListNode(-1), p = head;
        for (int v : list) {
            p.next = new ListNode(v);
            p = p.next;
        }

        return head.next;
    }

    protected void logRes(Object res) {
        logger.debug("res={}", res);
    }
}
